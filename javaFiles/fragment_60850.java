public class IntegerProperty extends Property<Integer> {
    @Override
    public void setValue(String input) {
        this.value = Integer.valueOf(input);
    }
}