package org.springframework.test.proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * 测试cglib
 * @author lyh
 * @date 2022/6/15 16:41
 */
public class TestCglib {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TargetObject.class);
		CallbackFilter callbackFilter = new TargetCallbackFileter();
		Callback noopCb = NoOp.INSTANCE;
		Callback methodInterceptor = new TargetInterceptor();
		Callback fixedValue = new TargetResultFixed();
		Callback[] callbacks = new Callback[]{methodInterceptor,noopCb, fixedValue};
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(callbackFilter);
		//enhancer.setCallback(new TargetInterceptor());
		TargetObject target = (TargetObject)enhancer.create();
		System.out.println(target.method1("hello"));
		System.out.println(target.method2(2)+"");
	}
}
