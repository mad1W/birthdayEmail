package com.madong.test;

import com.alibaba.fastjson.JSON;
import com.madong.BirthdayEmailApplication;
import com.madong.domain.ResultBean;
import com.madong.service.EmailService;
import com.madong.util.ReadTxtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BirthdayEmailApplication.class)
public class MyTest {

    @Autowired
    EmailService emailService;

    /**
     * 测试发送邮件
     */
    @Test
    public void sendEmailTest(){
        ResultBean resultBean = emailService.sendEmail("3107889098@qq.com", "这是邮件主题", "这是邮件的内容");
        System.out.println(JSON.toJSONString(resultBean));
    }

    /**
     * 测试读取txt
     */
    @Test
    public void readTxtTest() throws IOException {
        String txt = ReadTxtUtil.readTxt(ResourceUtils.getFile("classpath:employee.txt"));
        System.out.println(txt);
    }
}
