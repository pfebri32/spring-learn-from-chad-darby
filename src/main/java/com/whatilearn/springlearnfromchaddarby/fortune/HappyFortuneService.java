package com.whatilearn.springlearnfromchaddarby.fortune;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements IFortuneService {
    @Override
    public String getFortune() {
        return "This day is your lucky day.";
    }
}
