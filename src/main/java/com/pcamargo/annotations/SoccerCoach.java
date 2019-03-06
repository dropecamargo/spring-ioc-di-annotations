package com.pcamargo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {
	
	@Autowired
	@Qualifier("databaseFortuneService")
	public FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice corner kick 50 minuts";
	}
	
	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
