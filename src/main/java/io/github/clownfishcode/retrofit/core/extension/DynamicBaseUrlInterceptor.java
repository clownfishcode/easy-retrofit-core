package io.github.clownfishcode.retrofit.core.extension;

import io.github.clownfishcode.retrofit.core.RetrofitResourceContext;
import io.github.clownfishcode.retrofit.core.resource.RetrofitApiServiceBean;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author liuziyuan
 */
public class DynamicBaseUrlInterceptor extends BaseInterceptor {

    public DynamicBaseUrlInterceptor(RetrofitResourceContext context) {
        super(context);
    }

    @Override
    protected Response executeIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        final Method method = super.getRequestMethod(request);
        String clazzName = super.getClazzNameByMethod(method);
        final RetrofitApiServiceBean currentServiceBean = super.context.getRetrofitApiServiceBean(clazzName);
        final String realDynamicHostUrl = currentServiceBean.getRetrofitUrl().getDynamicUrl().getRealHostUrl();
        if (StringUtils.isNotEmpty(realDynamicHostUrl)) {
            final HttpUrl httpUrl = HttpUrl.get(realDynamicHostUrl);
            HttpUrl newUrl = request.url().newBuilder()
                    .scheme(httpUrl.scheme())
                    .host(httpUrl.host())
                    .port(httpUrl.port())
                    .build();
            request = request.newBuilder().url(newUrl).build();
        }
        return chain.proceed(request);
    }
}
