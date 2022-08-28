package com.microservice.sendemail.dtos;

import com.microservice.sendemail.models.EmailEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {

    @NotEmpty
    private String ownerRef;

    @NotEmpty
    @Email
    private String emailFrom;

    @NotEmpty
    @Email
    private String emailTo;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String text;

    public EmailDTO() {
    }

    public EmailDTO(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public EmailDTO(EmailEntity email) {
        this.ownerRef = email.getOwnerRef();
        this.emailFrom = email.getEmailFrom();
        this.emailTo = email.getEmailTo();
        this.subject = email.getSubject();
        this.text = email.getText();
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
