engine.eval("print(new MyWindow().test(param1));");
//                                     ^^^^^^

//                 vvvvvvvvvvvvv
public String test(String param1) {
    // how to get 'param1' value here
    return "in test";
}