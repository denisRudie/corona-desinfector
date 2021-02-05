package ru.job4j.configurators;

import ru.job4j.ApplicationContext;

/**
 * Аналог BeanPostProcessor из Spring.
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
