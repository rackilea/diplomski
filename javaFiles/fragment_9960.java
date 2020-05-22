public class ArrayWithFixedFirst {
    private final Integer[] numbers = new Integer[11];
    public Integer get(int index) {
        return numbers[index];
    }
    public void set(int index, Integer value) {
        if (index == 0) throw new IllegalArgumentException();
        numbers[index] = value;
    }
}