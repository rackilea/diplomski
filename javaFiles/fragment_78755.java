import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<String>();
        String[] programs = {"eclipse", "netbeans", "codeblocks", "visual studio"};

        ArrayList<String>convertedlist = new ArrayList<String>(Arrays.asList(programs));

        convertedlist.add("\nnotepad++");
        output(convertedlist);
        System.out.println("\nsorted list");                
        Collections.sort(convertedlist);
        output(convertedlist);
        System.out.println("\nreverse order");
        Collections.sort(convertedlist, Collections.reverseOrder());
        output(convertedlist);
        System.out.println("\nsecond array element");
        programs = convertedlist.toArray(new String[convertedlist.size()]);
        System.out.println(programs[1]);

        System.out.println("\nfilled list");
        Collections.fill(convertedlist, "L");
        output(convertedlist);
        System.out.println("\nadded all to list2");
        Collections.addAll(list2, programs);
        output(list2);
        System.out.println("\nfrequency of word net beans in list2");
        System.out.println(Collections.frequency(list2, "netbeans"));

    }
    public static void output(ArrayList<String> list){
        for(String a: list)
            System.out.printf("%s ", a);
    }

}