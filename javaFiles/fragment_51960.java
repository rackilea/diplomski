import java.util.*;

class Eval{
Eval(){         
}   
}

public class Ch11Ex7 {
public static void main(String[] args){ 

    Eval e1 = new Eval();
    Eval e2 = new Eval();
    Eval e3 = new Eval();
    Eval e4 = new Eval();
    Eval e5 = new Eval();

    Eval[] eva = {e1, e2, e3, e4, e5};

    //ArrayList<Eval> ev = new ArrayList<Eval>(Arrays.asList(eva));
    List ev = Arrays.asList(eva);
    List<Eval> sub = ev.subList(0, 2); 
    sub = new ArrayList<Eval>(sub);
    for(int i=0; i< ev.size() ; i++)
          System.out.println(ev.get(i));        
    System.out.println("Sublist");  
    for(int i=0; i< sub.size() ; i++)
          System.out.println(sub.get(i));   
    System.out.println("Remove element");
    sub.remove(1);
}