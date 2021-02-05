package ru.job4j.config;

import lombok.Getter;
import org.reflections.Reflections;
import ru.job4j.config.Config;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    /**
     * Маппинг интерфейса с его имплементацией.
     */
    private Map<Class, Class> ifcToImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifcToImplClass) {
        this.ifcToImplClass = ifcToImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    /**
     * Получение всех классов, реализующих данный интерфейс через сканирование переданного package.
     */
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifcToImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has zero or more than one impl. Please update " +
                        "your config");
            }
            return classes.iterator().next();
        });
    }
}
