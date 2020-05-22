public class Test {

    public static void main(String[] args) {
        List<Validator> v = new ArrayList<Validator>();
        v.add(new StringValidator());
        v.add(new IntegerValidator());

        for (Validator validator : v) {
            validator.validate();
        }
    }
}