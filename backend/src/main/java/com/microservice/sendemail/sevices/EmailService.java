package com.microservice.sendemail.sevices;

import com.microservice.sendemail.enums.StatusEmail;
import com.microservice.sendemail.models.EmailEntity;
import com.microservice.sendemail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    private JavaMailSender emailSender;

    @SuppressWarnings("finally")
    public EmailEntity sendEmail(EmailEntity entity) {
        entity.setSendDateEmail(LocalDateTime.now());
        try {
            emailSender.send(objectsEmail(entity));
        } catch (MailException e) {
            entity.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return repository.save(entity);
        }
    }

    private static SimpleMailMessage objectsEmail(EmailEntity entity) {
        var message = new SimpleMailMessage();
        message.setFrom(entity.getEmailFrom());
        message.setTo(entity.getEmailTo());
        message.setSubject(entity.getSubject());
        message.setText(entity.getText());
        entity.setStatusEmail(StatusEmail.SENT);
        return message;
    }
}
