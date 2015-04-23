package org.gradle;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;


public class TimeAgentTransformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader classLoader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] bytes)
			throws IllegalClassFormatException {
		
		byte[] result = bytes;
		
		if (className.contains("Stargate")) {
			try {

				String dotClassName = className.replace('/', '.');
				ClassPool cp = ClassPool.getDefault();
				cp.insertClassPath("C:\\Users\\Admin\\workspace\\restdemo\\target\\restservicedemo.jar");
				CtClass ctClazz = cp.get(dotClassName);

				CtField field = new CtField(CtClass.longType, "elapsedTime", ctClazz);
				field.setModifiers(1);
				ctClazz.addField(field);
				CtMethod method1 = ctClazz.getDeclaredMethod("travel");
				method1.insertBefore("this.elapsedTime = System.currentTimeMillis();");
				method1.insertAfter(" { this.elapsedTime = System.currentTimeMillis() - elapsedTime; "
				+ "System.out.println(\" Time passed = \" + elapsedTime);}");

				result = ctClazz.toBytecode();
			}

			catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
