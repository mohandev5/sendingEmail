package com.demo.emailSender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,String body,String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mohan.pekala1998@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        System.out.println("mail sending");
    }
    public void emailWithAttachment(String toEmail,String body,String subject,String attachment) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);

        messageHelper.setFrom("mohan.pekal1998@gmail.com");
        messageHelper.setTo(toEmail);
        messageHelper.setText(body);
        messageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(message);
        System.out.println("mail was sending");
    }
}
