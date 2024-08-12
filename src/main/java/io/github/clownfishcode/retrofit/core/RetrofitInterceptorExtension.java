package io.github.clownfishcode.retrofit.core;

import io.github.clownfishcode.retrofit.core.exception.RetrofitExtensionException;
import io.github.clownfishcode.retrofit.core.extension.BaseInterceptor;
import io.github.clownfishcode.retrofit.core.proxy.BaseExceptionDelegate;

import java.lang.annotation.Annotation;

public interface RetrofitInterceptorExtension {

    Class<? extends Annotation> createAnnotation();

    Class<? extends BaseInterceptor> createInterceptor();

    Class<? extends BaseExceptionDelegate<? extends RetrofitExtensionException>> createExceptionDelegate();

}
