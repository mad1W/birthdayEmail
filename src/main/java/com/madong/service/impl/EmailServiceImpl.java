package com.madong.service.impl;

import com.madong.domain.ResultBean;
import com.madong.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String serverEmail;

    @Override
    public ResultBean sendEmail(String account, String subject, String content) {
        ResultBean resultBean = new ResultBean();
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(serverEmail);
            message.setTo(account);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            resultBean.setCode(200);
            resultBean.setMsg("send email success");
        }catch (Exception e){
            logger.error("sendEmail error :", e);
            resultBean.setCode(500);
            resultBean.setMsg("send email fail");
        }
        return resultBean;
    }
}
