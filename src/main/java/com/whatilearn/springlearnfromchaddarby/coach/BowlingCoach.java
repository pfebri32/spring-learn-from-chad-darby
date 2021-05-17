package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class BowlingCoach implements ICoach {

    @Autowired
    @Qualifier("happyFortuneService")
    private IFortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Full strike 6 times until success.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
