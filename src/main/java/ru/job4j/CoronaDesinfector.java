package ru.job4j;

import ru.job4j.annotations.InjectByType;
import ru.job4j.services.Announcer;
import ru.job4j.services.Policeman;
import ru.job4j.services.Room;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        //сообщить всем присутствующим в комнате о начале дезинфекции и попросить выйти
        announcer.announce("Начинаем дезинфекцию, всем выйти!");
        //разогнать всех, кто не вышел после объявления
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        //сообщить всем, что они могут вернуться обратно
        announcer.announce("Вы можете рискнуть и вернуться обратно в комнату");
    }

    private void desinfect(Room room) {
        System.out.println("Зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус " +
                "низвергнут в ад");
    }
}
