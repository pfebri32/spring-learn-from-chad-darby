package com.whatilearn.springlearnfromchaddarby.coach;

import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BadmintonCoach implements ICoach {
    @Autowired
    @Qualifier("sadFortuneService")
    private IFortuneService fortuneService;

    @Value("${badminton.email}")
    private String email;
    @Value("${badminton.team}")
    private String team;

    @Override
    public String getDailyWorkout() {
        return "Sparing badminton 5 times.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    public void init() {
        System.out.println("\nBadmintonCoach: execute from init method with annotation.\n");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\nBadmintonCoach: execute from destroy method with annotation.");
        System.out.println("BadmintonCoach: destroy its not work in prototype scope.\n");
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
