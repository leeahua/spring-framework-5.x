package org.springframework.test.proxy;

import org.springframework.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {
	@Override
	public Object loadObject() throws Exception {
		System.out.println("lock reuslt ");
		Object obj = 1024;
		return obj;
	}
}
