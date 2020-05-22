class MyClass{
    private String comboStr;
    private String textStr;

    public MyClass{
        comboStr = "this goes in my combobox";
        textStr = "this goes in my textfield";
     }

    public String toString(){
        return comboStr;
    }

    public String getText(){
         return textStr;
    }
}