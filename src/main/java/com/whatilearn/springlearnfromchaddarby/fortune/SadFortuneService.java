package com.whatilearn.springlearnfromchaddarby.fortune;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements IFortuneService {
    @Override
    public String getFortune() {
        return "This is your bad day.";
    }
}
