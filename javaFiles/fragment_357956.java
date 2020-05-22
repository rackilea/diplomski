package jvm;

import java.util.ArrayList;
import java.util.List;

public class StringDeDuplicationTester {

    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 100_00; i++) {
                strings.add(new String("String " + i));
            }
            Thread.sleep(100);
        }
    }
}