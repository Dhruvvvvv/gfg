package com.gfg.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JVMDemo {

	public static void main(String[] args) {
		Object obj = new Object();
		Class c = obj.getClass();
		System.out.println("Class name:: " + c.getName());
		Method[] m = c.getMethods();
		for (Method mm : m) {
			System.out.println("Methods from the class:: " + mm);
		}

		Field f[] = c.getDeclaredFields();
		for (Field ff : f) {
			System.out.println("Fields from class:: " + ff.getName());
		}

	}

}
