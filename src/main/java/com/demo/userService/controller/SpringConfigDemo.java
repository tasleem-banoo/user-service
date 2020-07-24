package com.demo.userService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userService.entity.DBSettings;

@RestController
//@RefreshScope //only bean with this annotation will refresh configuration
public class SpringConfigDemo {
	
	@Value("${my.greeting}")
	private String greetingMsg;
	
	@Value("${app.description}")
	private String description;
	
	@Value("Static Message")
	private String staticMessage;
	
	@Value("${my.greeting.default: Hello Default Message}")
	private String greetingMsgDefault;
	
	@Value("${my.list.value}")
	private List<String> myList;
	
	@Value("#{${my.map.value}}")
	private Map<String, String> myMap;
	
	@Autowired
	private DBSettings dbSetting;
	
	@Autowired
	Environment env;
	
	@GetMapping("/greeting")
	public String getGreetings() {
		return greetingMsg+" "+description+" "+staticMessage+" "
		+greetingMsgDefault+" "+myList+" "+myMap;
	}
	
	@GetMapping("/configurationProperties")
	public String configurationPropertyDemo() {
		return dbSetting.getConnection()+","+dbSetting.getHost()+","+dbSetting.getPort();
	}
	
	@GetMapping("/envDetails")
	public String getEnvDetails() {
		return env.toString();
	}

}
