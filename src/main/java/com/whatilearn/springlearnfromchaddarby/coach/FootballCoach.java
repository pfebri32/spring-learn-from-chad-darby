package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.stereotype.Component;

public class FootballCoach implements ICoach {
    private final IFortuneService fortuneService;

    private String email;
    private String team;

    public FootballCoach(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Pinalty shoot for 50 times.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void init() {
        System.out.println("\nFootballCoach: execute from init method.\n");
    }

    public void destroy() {
        System.out.println("\nFootballCoach: execute from destroy method.");
        System.out.println("FootballCoach: destroy its not work in prototype scope.\n");
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
