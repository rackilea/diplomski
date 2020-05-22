public class MoveUppercaseChars {   

static String testcase1 = "Hello World";

public static void main(String args[]){
    MoveUppercaseChars testInstance = new MoveUppercaseChars();
    String result = testInstance.move(testcase1);
    System.out.println("Result : "+result);
}

public String move(String str){
    int len = str.length();
    String low = "";
    String cap = "";
    char ch;
    for(int i=0; i<len; i++)
    {
        ch = str.charAt(i);
        if(((int)ch >= 65) && ((int)ch <= 90))
        {
            cap  += ch;
        }   
        else {
            low += ch;
        }
    }
    return low + cap;
}   
}