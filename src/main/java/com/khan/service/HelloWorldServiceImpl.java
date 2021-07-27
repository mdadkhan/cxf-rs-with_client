package com.khan.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khan.jsonobj.model.EmployeesList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Path("/")
public class HelloWorldServiceImpl {

	
    @Produces({MediaType.APPLICATION_JSON })
    @POST
    @Path("/v1/postemployee/")
    @Operation(
        summary = "Post Employee JSON Object",
        description = "Get operation with Response and @Default value",
        responses = {
        		@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeesList.class)), responseCode = "200"),
        		@ApiResponse(responseCode = "404")
        }
    )
	public void postJsonEmployeee(EmployeesList employeesList) {
    	URL url = null;
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
			url =  new URL("http://localhost:8080/api/v1/process/employee");
			HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
			postConnection.setRequestMethod("POST");
			postConnection.setReadTimeout(60 * 1000);
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setRequestProperty("Accept", "application/json");
			
			System.out.println("About to invoke POST REST API thru HttpURLConnection ");
			//write content to the postConnection output stream
			postConnection.setDoOutput(true);
			
			OutputStream os = postConnection.getOutputStream();
			String jsonStr = mapper.writeValueAsString(employeesList);
			os.write(jsonStr.getBytes("utf-8"));
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();
			
			System.out.println("POST Response Code: " +responseCode);
			System.out.println("POST Response Message: " +postConnection.getResponseMessage());
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
				String inputLine;
				StringBuffer responseBuffer = new StringBuffer();
				while((inputLine = in.readLine()) != null) {
					responseBuffer.append(inputLine);
				}
				in.close();
				
				//print result
				System.out.println("FINAL : " +responseBuffer.toString() );
			}
			else {
				System.out.println("POST NOT WORKED");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

		
		//return empsList;
	}
	
}
