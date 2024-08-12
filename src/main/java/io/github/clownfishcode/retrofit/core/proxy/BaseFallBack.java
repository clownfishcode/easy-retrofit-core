package io.github.clownfishcode.retrofit.core.proxy;

import io.github.clownfishcode.retrofit.core.exception.RetrofitExtensionException;

public abstract class BaseFallBack<T extends RetrofitExtensionException> {

    protected abstract void setFallBackException(T e);

    public void setException(T exception) {
        setFallBackException(exception);
    }

}