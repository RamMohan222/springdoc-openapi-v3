package com.springdoc.openapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class SpringdocOpenapiV3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringdocOpenapiV3Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-title}") String appTitle,
			@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {
		// @formatter:off
		var info = new Info()
				.title(appTitle)
				.version(appVersion)
				.description(appDesciption)
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"));
		return new OpenAPI()
				.info(info)
				.externalDocs(new ExternalDocumentation()
						.description("Enternal Documentation")
						.url("https://ram222mohan.com"));
		// @formatter:on

	}

}
