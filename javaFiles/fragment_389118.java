public String doSomething(String input1, String input2) {
    CustomizedObject myobject = new CustomizedObject();
    Output out = null;
    try {
        out = (Output) myobject.getOutput();
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    return out.doSomethingString(input1, input2);
}