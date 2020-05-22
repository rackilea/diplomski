import java.util.*;
public enum Style {
    BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;

    public static void main(String[] args) {
        Set<Style> s1 = EnumSet.of(BOLD, UNDERLINE);
        System.out.println(s1); // prints "[BOLD, UNDERLINE]"

        s1.addAll(EnumSet.of(ITALIC, UNDERLINE));
        System.out.println(s1.contains(ITALIC)); // prints "true"
    }
}