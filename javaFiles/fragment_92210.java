import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MyClass {
static final String[] fileNames = {"a", ".b", "c", ".d", "e", ".f"};

public static void main(String[] args) {
    incorrect();
    corrected();
    improved();
}

public static void incorrect() {
    Map<Integer, String> myMap = new TreeMap<Integer, String>();

    for (int i = 0; i < fileNames.length; i++) {
        if (!fileNames[i].startsWith(".")) {
            myMap.put(i, fileNames[i]);
        }
    }

    System.out.println(myMap);

    for (int i = 0; i < fileNames.length; i++) {
        System.out.println(myMap.get(i));
    }
}

public static void corrected() {
    Map<Integer, String> myMap = new TreeMap<Integer, String>();

    for (int i = 0; i < fileNames.length; i++) {
        if (!fileNames[i].startsWith(".")) {
            myMap.put(i, fileNames[i]);
        }
    }

    System.out.println(myMap);

    for (int i = 0; i < fileNames.length; i++) {
        if (myMap.containsKey(i)) {
            System.out.println(myMap.get(i)); 
        }
    }
}

public static void improved() {
    List<String> myList = new ArrayList<String>();

    for (String fileName : fileNames) {
        if (!fileName.startsWith(".")) {
            myList.add(fileName);
        }
    }

    System.out.println(myList);

    for (String fileName : myList) {
        System.out.println(fileName);
    }
}