package com.example.keyauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v1/keyauth/")
public class KeyAuthController 
{

	@RequestMapping("name")
	public String getName()
	{
		return "Return Name <<Abhimanyu>> from KeyAuthController";
	}
	
}
