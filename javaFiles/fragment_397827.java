28 1 9 5 4 0 3

90 3 6 4 7

Scanner s = new Scanner("file path");
while (s.hasNextLine()) {
    String[] eachLine = s.nextLine().split("\\s+");
    //import java.util.Arrays;
    System.out.println(Arrays.toString(eachLine));
}