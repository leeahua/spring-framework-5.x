package org.springframework.test.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("call before: method:" + method.getName());
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("call after: method:" + method.getName() + ", result:" + result);
		return result;
	}
}
