public class findHidden {

 public static void main(String[] args) {
    boolean a=true;
    double n=0;
    do{
        a = hidden.MysterySquare.inSquare(n);
        System.out.println("a = " +a);
        n = n + .1;
    }while (a);//end while
    System.out.println("n = " +n);

  }//end main
}//end class