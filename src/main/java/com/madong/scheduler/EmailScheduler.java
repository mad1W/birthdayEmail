package com.madong.scheduler;

import com.madong.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    @Autowired
    EmailService emailService;

    /**
     * 每天凌晨执行一次
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void work() {
        emailService.readTxtAndSendEmail();
    }
}
