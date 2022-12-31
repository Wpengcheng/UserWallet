package com.cheng.wallet.utils;

public enum HttpStatus {
    OK(200, "成功"),
    ERROR(400, "系统错误")
    ;

    private Integer code;

    private String name;

    HttpStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
