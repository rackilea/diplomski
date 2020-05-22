public enum TestEnums {
    TEST_ENUM_1("I'm a field in enum 1"),
    TEST_ENUM_2("I'm a field in enum 2");

    String message;

    TestEnums(String message){
        this.message = message;
    }

    void doSomething(){
         System.out.print(message);
    }
}