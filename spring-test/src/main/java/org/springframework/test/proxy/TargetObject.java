package org.springframework.test.proxy;

public class TargetObject {

	public String method1(String name){
		return name;
	}

	public int method2(int num){
		return num;
	}

	@Override
	public String toString() {
		return "TargetObject{}" + getClass();
	}
}
