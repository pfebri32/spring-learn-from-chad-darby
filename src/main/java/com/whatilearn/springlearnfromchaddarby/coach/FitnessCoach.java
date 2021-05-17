package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FitnessCoach implements ICoach {
    private IFortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Push up for a hundred times.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
