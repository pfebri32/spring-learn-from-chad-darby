package com.whatilearn.springlearnfromchaddarby.config;

import com.whatilearn.springlearnfromchaddarby.coach.BadmintonCoach;
import com.whatilearn.springlearnfromchaddarby.coach.BowlingCoach;
import com.whatilearn.springlearnfromchaddarby.fortune.HappyFortuneService;
import com.whatilearn.springlearnfromchaddarby.fortune.IFortuneService;
import com.whatilearn.springlearnfromchaddarby.fortune.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.whatilearn.springlearnfromchaddarby")
@PropertySource("classpath:coach.properties")
public class SportConfig {
    @Bean
    public BowlingCoach bowlingCoach() {
        return new BowlingCoach();
    }

    @Bean
    public IFortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    @Bean
    public IFortuneService sadFortuneService() {
        return new SadFortuneService();
    }
}
