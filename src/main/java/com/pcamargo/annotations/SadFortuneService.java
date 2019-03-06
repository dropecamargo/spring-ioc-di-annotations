package com.pcamargo.annotations;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is sad fortune service";
	}

}
