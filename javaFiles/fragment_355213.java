public class Sprite<T> {
...
}

public class Living<T> extends Sprite<T> {
...
}

public class Entity extends Living<Entity> {
...
}