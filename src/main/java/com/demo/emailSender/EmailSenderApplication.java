package com.demo.emailSender;

import com.demo.emailSender.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSenderApplication {

	@Autowired
	private EmailService emailService;


	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		emailService.sendEmail("saikumar.koduru@imaginnovate.com","This is email body","shall we go to pantry");

		emailService.emailWithAttachment("mohan.pekal1998@gmail.com","This is email body with attachment","This email has an attachment","/home/mohan/Downloads/employee.csv");
	}

}
