public abstract class Sound<T extends Sound<T>> {
    public abstract boolean check(T d);
}

public class Alarm extends Sound<Alarm> {
    @Override
    public boolean check(Alarm d) { ... }
}