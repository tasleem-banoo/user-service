package com.demo.userService.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("db")
public class DBSettings {

	private String connection;
	private String host;
	private int port;
}
