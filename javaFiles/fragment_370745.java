class User {
    public static void main(String[] args) {

        EnumRadioButtons<MyEnum> bts 
                = new EnumRadioButtons<>(Arrays.asList(MyEnum.values()),
                        MyEnum::myToString); // user of method reference
    }
}