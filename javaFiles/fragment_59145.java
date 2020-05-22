public enum TestEnums implements IEnum{
    TEST_ENUM_1("I'm a field in enum 1");

    String message;

    TestEnums(String message){
        this.message = message;
    }

    public void doSomething(){
         System.out.print(message);
    }
}

interface IEnum{
    void doSomething();
}