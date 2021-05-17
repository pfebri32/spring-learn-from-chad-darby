package com.whatilearn.springlearnfromchaddarby;

import com.whatilearn.springlearnfromchaddarby.coach.*;
import com.whatilearn.springlearnfromchaddarby.config.SportConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnFromChadDarbyApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("/applicationContext.xml");
		ClassPathXmlApplicationContext beanScopeContext =
				new ClassPathXmlApplicationContext("/applicationBeanScopeContext.xml");
		ClassPathXmlApplicationContext beanLifecycleContext =
				new ClassPathXmlApplicationContext("/applicationBeanLifecycleContext.xml");
		ClassPathXmlApplicationContext annotationContext =
				new ClassPathXmlApplicationContext("/annotationContext.xml");

		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(SportConfig.class);

		FootballCoach footballCoach = context.getBean("footballCoach", FootballCoach.class);
		BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);

		System.out.println("\nAPPLICATION CONTEXT\n");
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		System.out.println(footballCoach.getEmail());
		System.out.println(footballCoach.getTeam());
		System.out.println();

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());
		System.out.println(baseballCoach.getEmail());
		System.out.println(baseballCoach.getTeam());
		System.out.println();

		System.out.println("///\n///\n///");

		System.out.println("\nBEAN SCOPE\n");
		FootballCoach footballCoachSingleton =
				beanScopeContext.getBean("footballCoachSingleton", FootballCoach.class);
		FootballCoach footballCoachSingleton2 =
				beanScopeContext.getBean("footballCoachSingleton", FootballCoach.class);
		FootballCoach footballCoachPrototype =
				beanScopeContext.getBean("footballCoachPrototype", FootballCoach.class);
		FootballCoach footballCoachPrototype2 =
				beanScopeContext.getBean("footballCoachPrototype", FootballCoach.class);

		boolean singletonResult = footballCoachSingleton == footballCoachSingleton2;
		boolean prototypeResult = footballCoachPrototype == footballCoachPrototype2;

		System.out.println("Result equals from scope singleton: " + singletonResult);
		System.out.println("Memory allocation from footballCoachSingleton" + footballCoachSingleton);
		System.out.println("Memory allocation from footballCoachSingleton2" + footballCoachSingleton2);
		System.out.println();

		System.out.println("Result equals from scope prototype: " + prototypeResult);
		System.out.println("Memory allocation from footballCoachPrototype" + footballCoachPrototype);
		System.out.println("Memory allocation from footballCoachPrototype2" + footballCoachPrototype2);
		System.out.println();

		System.out.println("///\n///\n///");

		System.out.println("\nBEAN LIFECYCLE\n");

		FootballCoach footballCoachLifecycle =
				beanLifecycleContext.getBean("footballCoach", FootballCoach.class);

		System.out.println("///\n///\n///");

		System.out.println("\nANNOTATION CONTEXT\n");

		ICoach trackCoachAnnotation =
				annotationContext.getBean("trackCoach", ICoach.class);
		ICoach fitnessCoachAnnotation =
				annotationContext.getBean("fitnessCoach", ICoach.class);
		BadmintonCoach badmintonCoachAnnotation =
				annotationContext.getBean("badmintonCoach", BadmintonCoach.class);

		System.out.println(trackCoachAnnotation.getDailyWorkout());
		System.out.println(trackCoachAnnotation.getDailyFortune());
		System.out.println();

		System.out.println(fitnessCoachAnnotation.getDailyWorkout());
		System.out.println(fitnessCoachAnnotation.getDailyFortune());
		System.out.println();

		System.out.println(badmintonCoachAnnotation.getDailyWorkout());
		System.out.println(badmintonCoachAnnotation.getDailyFortune());
		System.out.println(badmintonCoachAnnotation.getEmail());
		System.out.println(badmintonCoachAnnotation.getTeam());
		System.out.println();

		System.out.println("///\n///\n///");

		System.out.println("\nANNOTATION SCOPE CONTEXT\n");

		BowlingCoach bowlingCoach =
				annotationContext.getBean("bowlingCoach", BowlingCoach.class);
		BowlingCoach bowlingCoach2 =
				annotationContext.getBean("bowlingCoach", BowlingCoach.class);

		boolean prototypeAnnotationResult = bowlingCoach == bowlingCoach2;

		System.out.println("Result equals from scope prototype with annotation: " + prototypeAnnotationResult);
		System.out.println("Memory allocation from bowlingCoach" + bowlingCoach);
		System.out.println("Memory allocation from bowlingCoach2" + bowlingCoach2);
		System.out.println();

		System.out.println("///\n///\n///");

		System.out.println("\nANNOTATION LIFECYCLE METHOD CONTEXT\n");

		System.out.println("///\n///\n///");

		System.out.println("\nJAVA CONFIGURATION CONTEXT\n");

		ICoach bowlingCoachByJavaConfigContext =
				annotationConfigApplicationContext.getBean("bowlingCoach", ICoach.class);

		System.out.println(bowlingCoachByJavaConfigContext.getDailyWorkout());
		System.out.println(bowlingCoachByJavaConfigContext.getDailyFortune());
		System.out.println();

		System.out.println("///\n///\n///");


		context.close();
		beanScopeContext.close();
		beanLifecycleContext.close();
		annotationContext.close();
		annotationConfigApplicationContext.close();
//		SpringApplication.run(SpringLearnFromChadDarbyApplication.class, args);
	}
}
