package com.madong.controller;

import com.madong.domain.ResultBean;
import com.madong.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/sendEmail")
    public ResultBean sendEmail(){
        return emailService.readTxtAndSendEmail();
    }
}
