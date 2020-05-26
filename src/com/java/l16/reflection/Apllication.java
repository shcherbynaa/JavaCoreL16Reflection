package com.java.l16.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Apllication {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class cl = Book.class;

		String nameOfClass = cl.getName();
		String simpleNameOfClass = cl.getSimpleName();
		System.out.println("name of class: " + nameOfClass);
		System.out.println("simple name of class: " + simpleNameOfClass);

		int modifier = cl.getModifiers();
		System.out.println("modifiers: " + modifier);
		String modifierText = Modifier.toString(modifier);
		System.out.println("modifier text: " + modifierText);

		Package classPackage = cl.getPackage();
		System.out.println("package: " + classPackage);

		Class superClass = cl.getSuperclass();
		System.out.println("superclass: " + superClass);

		Class[] interfaces = cl.getInterfaces();
		System.out.println("interfaces: " + Arrays.toString(interfaces));

		Constructor[] classConstructor = cl.getConstructors();
		System.out.println("constructors: " + Arrays.toString(classConstructor));
		System.out.println("constructors size: " + classConstructor.length);
		System.out.println();

		Constructor<Book>[] bookConstructor = cl.getConstructors();

		for (int i = 0; i < bookConstructor.length; i++) {
			Constructor<Book> constructor = bookConstructor[i];
			System.out.println("constructor: " + constructor);
		}

		Constructor<Book> constructor = bookConstructor[0];
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println(class1);
		}

		System.out.println();
		System.out.println("get constructor by parameters");
		Constructor<Book> singleConstructor = cl.getConstructor(String.class, int.class, String.class);
		System.out.println("single constructor: " + singleConstructor);

		Book newInstance = singleConstructor.newInstance("Java", 1999, "Schildt");
		System.out.println("new instance: " + newInstance);
		System.out.println();

		Field[] fields = cl.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("field" + field);

		}

		fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("field " + field);
		}

		Field nameField = cl.getField("name");
		nameField.set(newInstance, "C++");
		System.out.println("instance with new name " + newInstance);

		Field privateYearField = fields[1];
		privateYearField.setAccessible(true);
		System.out.println("private value Year: " + privateYearField.get(newInstance));

		System.out.println();
		System.out.println("METHODS");

		Method[] methods = cl.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}

		methods[4].invoke(newInstance, "Python");
		System.out.println("instance with new name " + newInstance);
	}
}
