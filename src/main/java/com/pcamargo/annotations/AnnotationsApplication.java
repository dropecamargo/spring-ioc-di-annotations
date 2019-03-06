package com.pcamargo.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
		
		// Spring config - File XML
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Spring config - Java Class  
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		System.out.println("\nAnnotations config (Setter injection) ----------------");
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		Coach scoach = context.getBean("soccerCoach", Coach.class);
		System.out.println(scoach.getDailyWorkout());
		System.out.println(scoach.getDailyFortune());
		
		System.out.println("\nAnnotations dependency injection ----------------");
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		System.out.println("\n@Qualifier ----------------");
		Coach bCoach = context.getBean("baseballCoach", Coach.class);
		System.out.println(bCoach.getDailyWorkout());
		System.out.println(bCoach.getDailyFortune());
		
		System.out.println("\n@value value dependecy injection ----------------");
		TennisCoach tCoach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println(tCoach.getDailyWorkout());
		System.out.println(tCoach.getDailyFortune());
		System.out.println(tCoach.getEmail());
		System.out.println(tCoach.getTeam());
		
		System.out.println("\nBean Scope annotations ----------------");
		Coach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		Coach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Result compare object (Scopes): " + result);
		System.out.println("Memory location theCoach "	 + theCoach);
		System.out.println("Memory location theCoach " + alphaCoach);
		
		System.out.println("\nBean define Java Config Class ----------------");
		Coach swcoach = context.getBean("swinCoach", Coach.class);
		System.out.println(swcoach.getDailyFortune());
		System.out.println(swcoach.getDailyWorkout());
		
		context.close();
	}

}
