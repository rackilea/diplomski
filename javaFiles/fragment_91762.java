public class T1 {
    SortedMap<Integer, String>  m=new TreeMap<Integer, String>();
    void add(Integer i,String n){
        m.put(i,n);
        if(m.size()>3){
            m.tailMap(m.lastKey()).clear();
        }
        System.out.println(m);
    }
    public static void main(String[] args) {
        T1 t = new T1();
        t.add(1,"a");t.add(2,"b");t.add(3,"c");t.add(4,"d");t.add(0,"e");
    }
}