package com.LaptopAdda.project.exception;

public class APIError {
    private Integer errorCode;
    private String errorDesc;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public APIError(Integer errorCode,String errorDesc) {
        this.errorCode=errorCode;
        this.errorDesc=errorDesc;
    }
}
