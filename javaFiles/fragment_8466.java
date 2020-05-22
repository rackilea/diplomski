package generarlista;
import java.util.*;

public class GenerarLista {
/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    int num;
    Scanner read = new Scanner (System.in);
    List<Integer> lista = new ArrayList<>();
    System.out.println("A list of 5 integers is generated and printed equal values\n");
    for (int i=1; i<6; i++){
        System.out.println("Enter the value "+ i +" element to populate the list");
        num = read.nextInt();
        lista.add(num);
    }
    System.out.println("Data were loaded \n");
    System.out.println("Values in the list are: ");

    Collections.sort(lista);

    List<Integer> duplicates = new ArrayList<>();

    for (int i = 0; i < lista.size(); i++) {
        System.out.print(lista.get(i) + " ");
        if (i < lista.size()-1 && lista.get(i) == lista.get(i+1))
            if (!duplicates.contains(lista.get(i))
                duplicates.add(lista.get(i));
    }      

    System.out.println("\n");
    System.out.println("Equals are: ");

    for (int i = 0; i < duplicates.size(); i++) {
        System.out.print(duplicates.get(i) + " ");
    }

}

}