import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hack {

    public static void main(String[] args) {
        new Hack();
    }

    public Hack() {
        System.out.println("152 = " + getBeauty("ABbCcc"));
        System.out.println("754 = " + getBeauty("Good luck in the Facebook Hacker Cup this year!"));
        System.out.println("491 = " + getBeauty("Ignore punctuation, please :)"));
        System.out.println("729 = " + getBeauty("Sometimes test cases are hard to make up."));
        System.out.println("646 = " + getBeauty("So I just go consult Professor Dalves\t"));
    }

    protected int getBeauty(String value) {

        int sum = 0;
        value = value.toLowerCase();
        char[] values = value.toCharArray();
        Map<Character, Beauty> mapBeauty = new HashMap<>(26);
        for (char c : values) {
            if (Character.isLetter(c)) {
                Beauty beauty = mapBeauty.get(c);
                if (beauty == null) {
                    beauty = new Beauty(c);
                    mapBeauty.put(c, beauty);
                }
                beauty.add();
            }
        }

        List<Beauty> beauties = new ArrayList<>(mapBeauty.values());
        Collections.sort(beauties);
        int weight = 26;
        for (Beauty beauty : beauties) {
            int bweight = weight * beauty.getOccurance();
//            System.out.println(beauty.getValue() + " @ " + beauty.getOccurance() + " x " + weight + " = " + bweight);
            sum += bweight;
            weight--;
        }

        return sum;

    }

    public class Beauty implements Comparable<Beauty> {

        private char value;
        private int occurance;

        public Beauty(char value) {
            this.value = value;
            occurance = 0;
        }

        public char getValue() {
            return value;
        }

        public void add() {
            occurance++;
        }

        public int getOccurance() {
            return occurance;
        }

        @Override
        public int compareTo(Beauty o) {
            return o.getOccurance() - getOccurance();
        }

    }

}