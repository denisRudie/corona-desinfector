package ru.job4j.services;

import ru.job4j.annotations.InjectByType;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    /**
     * Вторичный конструктор.
     */
    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш-кыш");
    }
}
