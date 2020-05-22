package practice.with.arrays.and.io;

import java.io.IOException;
import java.io.PrintWriter;

public class PracticeWithArraysAndIO {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter("myFile.txt")) {
            out.println("hello");
        }
    }

}