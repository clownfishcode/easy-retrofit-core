package io.github.clownfishcode.retrofit.core.exception;

/**
 * @author liuziyuan
 */
public class BaseUrlException extends RetrofitBaseException {

    public BaseUrlException(String message) {
        super(message);
    }

    public BaseUrlException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
