package com.khan.sb;


import java.util.Collections;

import org.apache.cxf.feature.Feature;
import org.apache.cxf.jaxrs.openapi.OpenApiFeature;
//import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@ImportResource("classpath:beans.xml")
public class FeaturesConfig {

//  @Value("${cxf.path}")
//  private String basePath;
//
//  @Bean("openApiFeature")
//  public Feature swagger2Feature() {
//	  final OpenApiFeature feature = new OpenApiFeature();
//	  feature.setContactEmail("cxf@apache.org");
//	  feature.setLicense("Apache 2.0 License");
//	  feature.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");           
////	  feature.setSecurityDefinitions(Collections.singletonMap("basicAuth",new SecurityScheme().type(Type.HTTP)));
//	  return feature;
//  }
//  
//  @Bean
//  public JacksonJsonProvider jsonProvider() {
//    return new JacksonJsonProvider();
//  }
  
}  
