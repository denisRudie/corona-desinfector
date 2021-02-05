package ru.job4j;

import lombok.Getter;
import lombok.Setter;
import ru.job4j.annotations.Singleton;
import ru.job4j.config.Config;
import ru.job4j.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Аналог ApplicationContext из Spring. Кэширование синглтонов.
 */
public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    @Getter
    private final Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    /**
     * Получение объекта переданного класса/интерфейса. Если объект уже есть в кэше - то вернется
     * из кэша.
     * Если нет - то через фабрику создастся новый объект и добавится в кэш.
     * Если передан интерфейс, то через конфиг будет вычислен имплементирующий класс.
     */
    public <T> T getObject(Class<T> type) {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
