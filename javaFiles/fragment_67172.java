public enum Color {
    BLACK, GREEN, INVISIBLE, RED, SABLE
}

public abstract class Dog {
    protected final Color color;
    public Dog(final Color color) {
        if (!this.getValidColors().contains(color)) {
            throw new IllegalArgumentException(color);
        }
        this.color = color;
    }
    public abstract List<Color> getValidColors();
}

public class Shepherd extends Dog {
    public Shepherd(final Color color) {
        super(color);
    }
    @Override
    public List<Color> getValidColors() {
        return Arrays.asList(Color.BLACK, Color.GREEN, Color.INVISIBLE);
    }
}

public class Corgi extends Dog {
    public Corgi(final Color color) {
        super(color);
    }
    @Override
    public List<Color> getValidColors() {
        return Arrays.asList(Color.RED, Color.BLACK, Color.SABLE);
    }
}