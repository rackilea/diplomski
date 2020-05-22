package eu.webfarmr;

import java.util.ArrayList;
import java.util.List;

public class Dummy {
    public static void main(String[] args) {
        String[] x = {"a", "b", "c"};
        String[] y = {"d", "e", "f", "g"};
        String[] z = {"h", "i"};
        ArrayList<String[]> list = new ArrayList<String[]>();
        list.add(x);
        list.add(y);
        list.add(z);
        List<String> result = product(list);
        for (String r : result){
            System.out.println(r);
        }
    }

    private static ArrayList<String> product(ArrayList<String[]> items){
        ArrayList<String> result = new ArrayList();
        if (items!=null && items.size()>0){
            String[] currentItem = items.get(0);
            ArrayList<String[]> clone = (ArrayList<String[]>) items.clone();
            clone.remove(0);
            for (String item : currentItem){                
                ArrayList<String> product = product(clone);
                if (product!=null && product.size()>0){
                    for (String p : product){
                        result.add(item+p);
                    }
                } else {
                    result.add(item);
                }
            }
        }
        return result;
    }
}