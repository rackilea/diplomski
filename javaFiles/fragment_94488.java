public class StackTest {

    public static void main(String[] args) {
        List<String> arraylist = new ArrayList<String>();
        arraylist.add("hello there");
        arraylist.add("blah");
        arraylist.add("   cats    dogs");
        arraylist.add(" ");
        arraylist.add(" ");
        arraylist.add(" ");

        int words = 0;
        for(String s:arraylist) {
            s = s.trim().replaceAll(" +", " "); //clean up the String
            if(!s.isEmpty()){ //do not count empty strings
               words += s.split(" ").length;
            }
        }
        System.out.println(words);
    }
}