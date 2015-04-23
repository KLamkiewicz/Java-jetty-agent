package org.gradle;

import java.lang.instrument.Instrumentation;

public class TimeAgent {
	public static void premain(String agentArgs, Instrumentation inst){
		System.out.println("================== Agent is up and running ================");
		inst.addTransformer(new TimeAgentTransformer());
	}
}
