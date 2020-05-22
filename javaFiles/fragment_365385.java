public class Main {
public static void main(String[] args) throws FileNotFoundException {
    File file = new File("C:/Users/Anton/Pictures/1 x geotransform0.5m shading.txt");
    Scanner scan = new Scanner(file);
    //Scanning
    //first scan the whole file into a string (because a sting can have more than one line)
    String temp = "";
    while(scan.hasNextLine()){
        temp = scan.nextLine();
    }
    //now add the string to tokeinzer
    StringTokenizer st = new StringTokenizer(temp,"!-");
    //now give output
    while(st.hasMoreTokens()){
    String temp2 = st.nextToken();
        if(temp2.equals("   ===========  ALL OBJECTS IN CLASS: FENESTRATIONSURFACE:DETAILED ===========")) {
            System.out.print(temp2);
        }
    }
    scan.close();
}
}
}