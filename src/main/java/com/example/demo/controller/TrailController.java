package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trail")
public class TrailController {

	@RequestMapping("/status")
	public String getAppStatus() {
		return "your app working fine";
	}
}
