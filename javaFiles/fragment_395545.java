public interface Ordering<T> {
    int toOrdinal(T obj);
    T toObject(int ordinal);
}

public class IntegerOrdering implements Ordering<Integer> {
    @Override
    public int toOrdinal(Integer obj) {
        return obj;
    }

    @Override
    public Integer toObject(int ordinal) {
        return ordinal;
    }
}

public class CharacterOrdering implements Ordering<Character> {
    @Override
    public int toOrdinal(Character obj) {
        return obj;
    }

    @Override
    public Character toObject(int ordinal) {
        return (char)ordinal;
    }
}