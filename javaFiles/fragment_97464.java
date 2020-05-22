public class SortedVector extends Vector {
    public void addElement(Object o){
        super.add(o);
        Collections.sort(this); // Note the usage of this
    }
}