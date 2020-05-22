import java.util.*;
import java.io.*;


public class Nick {
    String[] abel() throws IOException {
        int i = 0;
        BufferedReader wczytaj = new BufferedReader(new FileReader("filmy.txt"));
        StringBuilder sb = new StringBuilder();
        String tekst = wczytaj.readLine();
        while (tekst != null) {
            sb.append(tekst);
            sb.append("\n");
            tekst = wczytaj.readLine();
        }
        String calosc = sb.toString();
        String film = calosc;
        String znak = ",";
        String[] tab;
        tab = film.split(znak);
        for (i = 0; i < tab.length; i++) {
            System.out.println("listusia: " + i + " " + tab[i]);
        }
        List<String> list = Arrays.asList(tab);
        Collections.reverse(list);
        tab = (String[]) list.toArray();
        for (i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
        return tab;

    }

    public static void main(String[] args) throws IOException {
        Nick nick = new Nick();
        nick.abel();
    }

}