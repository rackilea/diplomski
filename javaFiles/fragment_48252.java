public class MyCollection<T> {

    private T[] t;

    MyCollection( int size){
        t = (T[]) new Object[size];
    }

    boolean addElement(T e, int i){        
        if(i < t.length){
            t[i] = e;
            return true;
        }
        return false;

    }

    T getElement(int index) {
        return t[index];
    }

    int getLength() {
        return t.length;
    }

    public static void main(String[] ss){

        MyCollection<String> k = new MyCollection<String>(3);

        k.addElement("a",0);
        k.addElement("b",1);
        k.addElement("c",2);

        for(int i = 0; i < k.getLength(); i++)
            System.out.println(k.getElement(i));     

        //for(String s : (String[])k.t)
        //    System.out.println(s);        
     }
}