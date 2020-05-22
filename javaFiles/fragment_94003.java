public class AllTheSameCheck implements CheckStrategy {
    @Override
    public String getName() {
        return "allTheSame";
    }

    @Override
    public boolean validate(Object toValidate, String arguments) {
        ...
    }
}