package com.pcamargo.annotations;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swin 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
