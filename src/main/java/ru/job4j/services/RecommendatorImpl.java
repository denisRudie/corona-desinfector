package ru.job4j.services;

import ru.job4j.annotations.InjectProperty;
import ru.job4j.annotations.Singleton;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("whiskey")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-2019 drink " + alcohol);
    }
}
