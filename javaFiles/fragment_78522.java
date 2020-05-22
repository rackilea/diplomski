public abstract class Store {
    private String name;
    private Item items;
    //..other items
}
public class Mall {
    private Store myStore;
    //Vector which Stores all Store objects
    private List<Store> listOfStores=new LinkedList();
    //stores method which returns an Enumeration of Stores*/
    public Iterator<Store> stores(){
        return listOfStores.iterator();
    }
    public void addStore(Store s){
        listOfStores.add(s);
    }
}