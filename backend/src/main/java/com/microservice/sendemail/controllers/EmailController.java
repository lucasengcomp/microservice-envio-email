package com.microservice.sendemail.controllers;

import com.microservice.sendemail.dtos.EmailDTO;
import com.microservice.sendemail.models.EmailEntity;
import com.microservice.sendemail.sevices.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController(value = "emails")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("sending-email")
    public ResponseEntity<EmailEntity> sendingEmail(@Valid @RequestBody EmailDTO dto) {
        var entity = new EmailEntity();
        BeanUtils.copyProperties(dto, entity); //convert dto to entity
        service.sendEmail(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }
}
