public class Factorial {
public String value;
public void sequence(){
    value = JOptionPane.showInputDialog("Please enter the number of which you want your shit.");
    System.out.println("Factorial:");
    System.out.println(fact(Integer.valueOf(value)));
    getValues(Integer.valueOf(value));
}

public static int getValues(int n){
    return n;
}
public String getValue(){return value;}
}

public class Fibonacci extends Factorial {
    //Method sequence is overridden here
    public void sequence(){
//can use getValue() here or anywhere...there is no need to use a separate object due to inheritance
}
}