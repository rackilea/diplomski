class Main {
    interface Test{
        String method();
    }
    void w(){
        String str = "foo";
        str = "bar";
        String tmpStr = str;
        Test t = () -> tmpStr;
    }
}