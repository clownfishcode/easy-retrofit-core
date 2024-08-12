package io.github.clownfishcode.retrofit.core.exception;

/**
 * @author liuziyuan
 */
public class RetrofitBaseException extends RuntimeException {

    public RetrofitBaseException(String message) {
        super(message);
    }

    public RetrofitBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
