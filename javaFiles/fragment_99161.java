import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatesIgnoreCase {
    public static void main(String args[]) {

        // String Array with duplicates Colors
        String[] colorArray={"Black","BLACK","black","Cobalt","COBALT","cobalt","IVORY","Ivory","ivory","White","WHITE","white"};
        List<String> uniqueColorList=new IgnoreCaseStringList<String>();
        for (String color : colorArray) {
            if(!uniqueColorList.contains(color))
            {
                uniqueColorList.add(color);
            }
        }
        Iterator<String> itr=uniqueColorList.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }

}

public class IgnoreCaseStringList extends ArrayList<String> {
    @Override
    public boolean contains(Object o) {
        String paramStr = (String)o;
        for (String s : this) {
            if (paramStr.equalsIgnoreCase(s)) return true;
        }
        return false;
    }
}