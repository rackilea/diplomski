public class MyStringClass{

    private String string = null;

    public MyStringClass(String s){
        string = s;
    }
    public String getValue(){
        return string;
    }
    public void setValue(String s){
        string = s;
    }
}