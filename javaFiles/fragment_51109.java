package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Anagrams {

    private static ArrayList<Character> convert(String txt) {
    ArrayList<Character> alph = new ArrayList<Character>();
    for (int i = 0; i < txt.length(); i++)
        if (Character.isLetter(txt.charAt(i)))
        alph.add(Character.toLowerCase(txt.charAt(i)));
    Collections.sort(alph);
    return alph;
    }

    public static void main(String[] args) {
    ArrayList<String> first = new ArrayList<String>();
    first.add("it's");
    first.add("Sit");
    first.add("yes-man");
    first.add("murdered");
    first.add("ok");
    first.add("DereDrum");
    first.add("Hello");
    first.add("Friend");

    ArrayList<String> second = new ArrayList<String>();
    second.add("its");
    second.add("sit");
    second.add("yesman");
    second.add("murdered");
    second.add("ok");
    second.add("deredrum");
    second.add("hello");
    second.add("friend");

    ArrayList<Integer> checked = new ArrayList<Integer>();

    for (int i = 0; i < first.size(); i++) {
        String line = "";
        if (!checked.contains(i))
        line += first.get(i) + " ";

        ArrayList<Character> firstChrAry = convert(first.get(i));

        for (int j = i + 1; j < second.size(); j++) {
        ArrayList<Character> secondChrAry = convert(second.get(j));
        if (firstChrAry.size() == secondChrAry.size()) {
            if (firstChrAry.equals(secondChrAry)) {
            line += first.get(j);
            checked.add(j);
            }
        }
        }
        if (!line.equals(""))
        System.out.println(line);
    }

    }
}