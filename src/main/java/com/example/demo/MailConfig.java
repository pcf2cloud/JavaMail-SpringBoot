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
	
	
	@Autowired
	public MailConfig(JavaMailSender mailSender) {
		
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/Send")
	public String mailSend() {
		
		SimpleMailMessage mail = 	getSimpleMailMessage(String.format("%s is started ", "Bye"),String.format("per your request, we are informing you that %s is starting ", "Hello"));
			
		mailSender.send(mail);
		
		return "Send";
	}
	public  SimpleMailMessage getSimpleMailMessage(String subject, String text) {
		// TODO Auto-generated method stub
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("xxxxx@gmail.com");
		mail.setSubject(subject);
		mail.setText(text);
		
		return mail;
		
	}
}
