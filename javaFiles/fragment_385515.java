public class IceCream implements Comparator{
    // ...
    final String name; 
    final Date date;
    public Icecream(String name, Date date){
       this.name = name;
       this.date = date;
    }
    public int compare(Object o1, Object o2) {
        return ((IceCream)o1).date.compareTo(((IceCream)o2).date);
    }
}