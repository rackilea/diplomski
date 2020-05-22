public class MyClass {
    private String firstField, secondField;
    private ThirdField thirdField;
    private FifthField fifthField;

    public static class ThirdField {
        private List<ThirdFieldItem> thirdField;
    }

    public static class ThirdFieldItem {
        private String thirdField_one, thirdField_two;
    }

    public static class FifthField {
        private List<FifthFieldItem> fifthField;
    }

    public static class FifthField {
        private String fifthField_one, fifthField_two;
        private int fifthField_three;
    }
}