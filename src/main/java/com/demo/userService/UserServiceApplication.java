package com.demo.userService;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableDiscoveryClient
@SpringBootApplication
/* Soap has wsdl for documentation but rest does not have any documentation spec. this is how swagger comes into picture.
 * http://localhost:8860/v2/api-docs
 * http://localhost:8810/swagger-ui.html
 */
@EnableSwagger2
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2) //creating new docket instance that is configured to use swagger 2
				.select() //docket instance is manipulated using builder pattern. select() will get docket builder object.this builder has methods that lets us to customize how swagger behaves. in the end we can call build() method to get prepared docket object. 
				//.paths(PathSelectors.ant("/depts/*"))
				.apis(RequestHandlerSelectors.basePackage("com.demo"))
				.build()
				.apiInfo(apiDetails()); //adding application metadata
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("User APIs", "Sample APIs for Demo", 
				"1.0", "Free to use", 
				new springfox.documentation.service.Contact("Tasleem Banoo", "localhost:8810", "banootasleem2@gmail.com"), 
				"API License", "http://localhost:8810", Collections.emptyList());
	}

}

