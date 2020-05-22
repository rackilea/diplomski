public class Anthill<T extends Ant_Abstract>{
     public ArrayList<T> occupants = new ArrayList<>(15);

     public void enter(T ant){
            occupants.add(ant);
     }
}