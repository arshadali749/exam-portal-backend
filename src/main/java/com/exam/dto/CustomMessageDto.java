package com.exam.dto;
import java.util.Date;

public class CustomMessageDto {
    private String message;
    private String statuscode;
    private String date;

    public CustomMessageDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = new Date().toString();
    }
}
