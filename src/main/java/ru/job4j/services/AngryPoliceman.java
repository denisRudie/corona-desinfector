package ru.job4j.services;

public class AngryPoliceman implements Policeman {

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Всех убью! Вон пошли");
    }
}
