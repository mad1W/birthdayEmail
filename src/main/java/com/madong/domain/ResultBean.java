package com.madong.domain;

public class ResultBean {
    //返回信息常量
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAIL_MESSAGE = "fail";
    //返回状态码常量
    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = 500;

    //状态码
    private Integer code;
    //返回信息
    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean() {
    }

    private ResultBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
