package ru.job4j;

import ru.job4j.runner.Application;
import ru.job4j.services.Policeman;
import ru.job4j.services.PolicemanImpl;
import ru.job4j.services.Room;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.job4j", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
