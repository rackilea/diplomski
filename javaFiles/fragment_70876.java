@AssistedInject
A(final Apple apple,
        @Assisted("raw") List<Fruits> rawFruits,
        @Assisted("ripe") List<Fruits> ripeFruits) {
}

public interface Factory {
    A create(@Assisted("raw") List<Fruits> rawFruits,
             @Assisted("ripe") List<Fruits> ripeFruits);
}