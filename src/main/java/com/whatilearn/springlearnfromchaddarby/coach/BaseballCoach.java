package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.stereotype.Component;

public class BaseballCoach implements ICoach {
    private IFortuneService fortuneService;

    private String email;
    private String team;

    @Override
    public String getDailyWorkout() {
        return "Batting for a hundred times.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
