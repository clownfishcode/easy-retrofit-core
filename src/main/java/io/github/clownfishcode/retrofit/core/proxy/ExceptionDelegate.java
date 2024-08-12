package io.github.clownfishcode.retrofit.core.proxy;

import io.github.clownfishcode.retrofit.core.exception.RetrofitExtensionException;

import java.lang.reflect.Method;

public interface ExceptionDelegate<T extends RetrofitExtensionException> {

    Object invoke(Object proxy, Method method, Object[] args, RetrofitExtensionException throwable);
}
