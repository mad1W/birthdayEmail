package com.madong.service.impl;

import com.madong.domain.ResultBean;
import com.madong.service.EmailService;
import com.madong.util.ReadTxtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public ResultBean readTxtAndSendEmail(){
        ResultBean resultBean = new ResultBean();
        try{
            List<String> txt = ReadTxtUtil.readTxt(ResourceUtils.getFile("classpath:employee.txt"));
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            String date = sdf.format(new Date());
            for (String info : txt) {
                String[] split = info.split(",");
                String employeeBirth = split[2];
                if(date.equals(employeeBirth)){
                    String account = split[3];
                    String subject = "生日祝福";
                    String content = split[0] + split[1] + "祝你生日快乐！";
                    sendEmail(account,subject,content);
                    logger.info("给"+split[0]+ split[1]+"发送了生日祝福邮件");
                }
            }
            resultBean.setCode(200);
            resultBean.setMsg("readTxtAndSendEmail success");
        }catch (Exception e){
            logger.error("readTxtAndSendEmail error :", e);
            resultBean.setCode(500);
            resultBean.setMsg("readTxtAndSendEmail fail");
        }
        return resultBean;
    }
}
