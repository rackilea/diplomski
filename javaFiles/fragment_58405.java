public class Printer<E> {

   public void printData(E[] arr) {
        for (E e : arr)
           System.out.println(e);
    }
}

Printer<Integer> intPrinter = new Printer<Integer>();