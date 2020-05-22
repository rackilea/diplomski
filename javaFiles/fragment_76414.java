/*How I tested the code*/
public class Main {
    public static int numberSearch;
    public static void main(String args[]) {
        int target = (int) (Math.random() * 1000);
        numberSearch = target;
        Finder.getResult();
    }
}

/*in a separate file*/
public class Finder {

    public static void getResult() {
        int t = Main.numberSearch;
        System.out.println(t);
    }

}