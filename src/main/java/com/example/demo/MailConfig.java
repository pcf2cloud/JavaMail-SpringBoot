package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
@RestController
public class MailConfig {

	@Autowired
	private  JavaMailSender mailSender;
	
	// connect mail server
	@Autowired
	public MailConfig(JavaMailSender mailSender) {
		
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/")
	public String appStatus() {
		
		
		
		return "application successfully deployed in cloud foundry";
	}
	
	@RequestMapping("/Send")
	public String mailSend() {
		
		SimpleMailMessage mail = 	getSimpleMailMessage(String.format("%s from  cloud ", "Mail"),String.format("per your request, we are informing you that %s is starting ", "application"));
			
		mailSender.send(mail);
		
		return "Send";
	}
	public  SimpleMailMessage getSimpleMailMessage(String subject, String text) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("pcf2cloud@gmail.com");
		mail.setSubject(subject);
		mail.setText(text);
		
		return mail;
		
	}
}
