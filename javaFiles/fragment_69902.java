package textfiles;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

public class CommandCenter {

static void reverseArray(String arr[], int start, int end)    {
    String temp;
    if (start >= end)
        return;
    temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverseArray(arr, start+1, end-1);
}

public static void main(String[] args) throws IOException {

    String file_name = "./input.txt";

    try {
        ReadFile file = new ReadFile(file_name);
        String[] aryLines = file.OpenFile();
        reverseArray(aryLines, 0, aryLines.length - 1);
        ArrayDeque<String> stack = new ArrayDeque<String>(Arrays.asList(aryLines));
        System.out.println(stack);                                                      //TEST  

    }   catch(IOException e) {
        System.out.println("Error!");
    }
  }
}