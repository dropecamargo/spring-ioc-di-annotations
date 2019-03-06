package com.pcamargo.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
		"One item ramdon fortune service",
		"Two item ramdon fortune service",
		"Tree item ramdon fortune service"
	};
	
	@Override
	public String getFortune() {
	    return this.data[new Random().nextInt(data.length)];
	}
}
