package com.example.restservicedemo.domain;

import java.util.Random;

public class Stargate {
	
	public void travel() {
		Random r = new Random();
		try {
			Thread.sleep((long)r.nextInt((1000-0)+1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Travel ended");
	}
}
