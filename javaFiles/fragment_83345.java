import java.util.ArrayList;

public class Sample {

    private static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add("Games");
        list.add("iphones");
        System.out.println(OccurencesOfCharacter('s'));
    }

    public static int OccurencesOfCharacter(char givenCharacter) {
        int count = 0;

        for(String s: list) {
            if(s.charAt(s.length()-1)==givenCharacter)
                count++;
        }

        return count;
    }

}