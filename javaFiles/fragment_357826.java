public class Main {
static String [] string1 = {
        "1","2",
        "3","4",
        "5","6",
        "7","8",
        "9","10"};

static ArrayList<String> as = new ArrayList<String>();
public static void main(String[] args) {

    for(int i =0;i<string1.length;i++){
        getArray(string1[i]);
    }
    System.out.println(as.toString());
}

public static void  getArray(String string){
    switch (string) {
    case "2":
        as.add("A");
        break;
    case "3":
        as.add("B");
        break;
    case "4":
        as.add("C");
        break;
    case "5":
        as.add("D");
        break;
    case "6":
        as.add("F");
        break;
    case "7":
        as.add("G");
        break;
    case "8":
        as.add("H");
        break;
    case "9":
        as.add("I");
        break;
    case "10":
        as.add("J");
        break;

    default:
        break;
       }
    }
}