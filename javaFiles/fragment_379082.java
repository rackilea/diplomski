import java.util.ArrayList;
import com.demo.Rules;

public class CompArray {
   public ArrayList<Rules> a1= new ArrayList<Rules>();

public CompArray (){
        Rules rul = new Rules();
        rul.setId("1001");
        rul.setDetails("khagfkj");
        rul.setParameter("lsrkjglkrs");
        rul.setValue("lskdjfk");

    a1.add(rul);


 }
public ArrayList<Rules> getRules(){


    return a1;
}
}