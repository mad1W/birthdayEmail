package com.madong.service;

import com.madong.domain.ResultBean;

public interface EmailService {
    /**
     * 发送邮件
     * @param account 邮箱账户
     * @param subject 邮箱主题
     * @param content 邮箱内容
     * @return ResultBean
     */
    ResultBean sendEmail(String account, String subject, String content);

    ResultBean readTxtAndSendEmail();
}
