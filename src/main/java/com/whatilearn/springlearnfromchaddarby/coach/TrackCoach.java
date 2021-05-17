package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.HappyFortuneService;
import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements ICoach {
    private final IFortuneService fortuneService;

    @Autowired
    public TrackCoach(@Qualifier("happyFortuneService") IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Running for 5km.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
