import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

 public class RecyclerTest {

    public static void main(String[] args) {
        RecyclerTest obj = new RecyclerTest();
        ArrayList<Object> arr_obj = obj.getRandomSublist(Cheeses.sCheeseStrings, 20);
        // System.out.println(arr_obj.toString()+"");

    }

    ArrayList<Object> getRandomSublist(String[] array, int amount) {
        final ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        Collections.sort(list, new sortList());
        return insert(list);
    }

    class sortList implements Comparator<String> {

        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }
    }

    ArrayList<Object> insert(ArrayList<String> arrayList) {
        ArrayList<Object> str = new ArrayList<>();
        ArrayList<Object> cc = new ArrayList<>();
        int count = arrayList.size();
          System.out.println(arrayList.toString());

        int i = 0;

     String prv = "";
     int letterscount=0;
      System.out.println(str.size());
        while (i < count) {
              //System.out.println(str.size());
            // Alphabets alphabets = new Alphabets(arrayList.get(i).substring(0,1));
            String temp = arrayList.get(i).substring(0, 1);

             if(!prv.equals(temp))
            {

                str.add(temp);

                int x = 0 ;

                while (temp.equalsIgnoreCase(arrayList.get(x).substring(0, 1))) {

                    if(!prv.equalsIgnoreCase(temp)){
                         str.add(arrayList.get(x));
                    }

                    x++;

                }

                letterscount++;
             } 

            if(!prv.equalsIgnoreCase(temp)){

                   int size = str.size()-letterscount;

                   System.out.println(str.toString());
                   str.add(arrayList.get(i));
                   System.out.println(size);

            }
            prv = temp;

            i++;
        }

        return str;
    }

}  


   class Cheeses {
        static String[] sCheeseStrings = {"Baby Swiss", "Bresse Bleu", "Bruder Basil", 
                "Charolais", "Charolais", "Coeur de Chevre", "Cold Pack", "Fourme de Montbrison",
                "Fresh Mozzarella", "Fromage Frais", "Havarti", "Le Fium Orbo", "Loddiswell Avondale",
                "Peekskill Pyramid", "Remedou", "Ricotta Salata", "Samso", "Tete de Moine", "Trou du Cru",
                "Tymsboro"};

        public Cheeses( ) {

        }
 }

  class Alphabets {
    String alp;

    public Alphabets(String alp) {
        this.alp = alp;
    }

    public String getAlp() {
        return alp;
    }
}