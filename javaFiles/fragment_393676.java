import java.util.ArrayList;

public class Generic <E extends Item> {

     private ArrayList<E> items = new ArrayList<E>();

        public void add(E neu) {
           this.items.add(neu);
        }

        public void problematic(E clazz) {

           this.add(clazz);  // this line is the problem
        }

}

class Item {}