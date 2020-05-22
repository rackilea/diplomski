package java.util;

import org.checkerframework.checker.interning.qual.*;

import javax.annotation.Nullable;

class Optional<T> {
    static <T> Optional<T> ofNullable(@Nullable T value);

    @Nullable T orElse(@Nullable T other);
}