package com.example.restservicedemo.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.domain.Stargate;

@Path("/")
public class PersonManager {
	
	
	@GET
	@Path("/travel")
	@Produces("text/html")
	public String test() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Stargate s = new Stargate();
		s.travel();
		System.out.println("Herro");
		return "Your journey is over it took " + s.getClass().getDeclaredField("elapsedTime").getLong(s) + " ms";
	}

}
