package org.springframework.test.proxy;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 回调拦截器
 * @author lyh
 * @date 2022/6/15 16:56
 */
public class TargetCallbackFileter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if(method.getName().equals("method1")){
			System.out.println("filter method:method1 == 1");
			return 1;
		}
		if(method.getName().equals("method2")){
			System.out.println("filter method:method2 == 0");
			return 0;
		}

		return 0;
	}
}
