package com.lzy.okhttputils.exception;

public class OkHttpException extends Exception {

    public static OkHttpException INSTANCE(String msg) {
        return new OkHttpException(msg);
    }

    public OkHttpException() {
        super();
    }

    public OkHttpException(String detailMessage) {
        super(detailMessage);
    }

    public OkHttpException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public OkHttpException(Throwable throwable) {
        super(throwable);
    }
}