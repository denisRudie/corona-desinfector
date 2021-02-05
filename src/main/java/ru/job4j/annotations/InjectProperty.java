package ru.job4j.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Считывание данных из пропертей - application.properties.
 * Если value не указано - то считывается пропертя по имени переменной.
 * Если указано - тогда считывается по value.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectProperty {
    String value() default "";
}
