package com.khan.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.khan.jsonobj.model.Employee;
import com.khan.jsonobj.model.Employees;
import com.khan.jsonobj.model.EmployeesList;
import com.khan.pojo.PersonPojo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;


@Path("/")
//@Api(value = "Hello resource Version 1", 
//consumes = MediaType.APPLICATION_JSON, 
//produces = MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public interface PersonService {
	

//	  @GET
//	  @Path("/v1/person/{id}")
//	  @ApiOperation(value = "Gets a hello resource. Version 1 - (version in URL)")
//	  @ApiResponses(value = {
//	    @ApiResponse(code = 200, message = "Person Found", response = PersonPojo.class),
//	    @ApiResponse(code = 404, message = "Hello resource not found")
//	  })	
//	public PersonPojo fetchPeron(@PathParam("id") String id);
	
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @GET
    @Path("/v1/person/{id}")
    @Operation(
        summary = "Get Person Object",
        description = "Get operation with Response and @Default value",
        responses = {
//            @ApiResponse(
//                content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonPojo.class))),
//                responseCode = "200"
//            )
        		@ApiResponse(content = @Content(schema = @Schema(implementation = PersonPojo.class)), responseCode = "200"),
        		@ApiResponse(responseCode = "404")
        }
    )	
	public PersonPojo fetchPeron(@PathParam("id") String id);	
    
    @Produces({MediaType.APPLICATION_JSON })
    @GET
    @Path("/v1/jsonperson/{id}")
    @Operation(
        summary = "Get Person JSON Object",
        description = "Get operation with Response and @Default value",
        responses = {
        		@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeesList.class)), responseCode = "200"),
        		@ApiResponse(responseCode = "404")
        }
    )	
	public EmployeesList fetchJsonPeron(@PathParam("id") String id);

    @Produces({MediaType.APPLICATION_JSON })
    @POST
    @Path("/v1/process/employee/")
    @Operation(
        summary = "Post Employee JSON Object",
        description = "Get operation with Response and @Default value",
        responses = {
        		@ApiResponse(content = @Content(schema = @Schema(implementation = Response.class)), responseCode = "200"),
        		@ApiResponse(responseCode = "404")
        }
    )
	public Response postProcessingJsonEmployeee(EmployeesList employeesList);
    
    
}	  