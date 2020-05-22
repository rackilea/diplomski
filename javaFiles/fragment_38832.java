public class Switch {
    public static void switch(String s){ // now s=x="Hello"
        s = "GOODBYE";   //here x="hello" , s ="GOODBYE"  i.e, you are changing "s" to point to a different String i.e, "GOODBYE", but "x" still points to "Hello"
    }
    public static void main(String[] args){
        String x = "HELLO";
        switch(x);
        System.out.println(x);
    }
}