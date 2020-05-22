import java.util.*;

public class SomaQuadrados {

    public static void main(String[] args) 
    {
        List<Integer> numeros = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNextInt()) {
            int numero = teclado.nextInt();
            numeros.add(numero);
        }

        System.out.println(somaQuadrados(numeros));
    }

    public static int somaQuadrados(List<Integer> numeros)
    {
        int size = numeros.size();

        if (size == 0)
        {
            return 0;
        }

        int numero = numeros.get(0);

        return numero * numero + somaQuadrados(numeros.subList(1, size));
    }
}