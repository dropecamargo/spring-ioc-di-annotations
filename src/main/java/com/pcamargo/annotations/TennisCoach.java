package com.pcamargo.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	@PostConstruct	
	public void doMyStartStuff() {
		System.out.println("TrackCoach start method doMyStartStuff");
	}
	
	@PreDestroy
	public void doMyDestroyStuff() {
		System.out.println("TrackCoach clean method doMyDestroyStuff");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}
	
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
}
