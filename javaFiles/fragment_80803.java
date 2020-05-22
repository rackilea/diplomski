public class SplitString {

public static void main(String[] args) {

    String s = "This is test string1./This is test string2@(#*$ ((@@{}";
    String[] fragments = s.split("/");
    String fragment1 = fragments[0];
    String fragment2 = fragments[1];

    System.out.println(fragment1);
    System.out.println(fragment2);

    }

}