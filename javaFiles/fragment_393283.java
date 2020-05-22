import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;


public class Practice {


    public static void main (String[] args) {

//      ArrayList<String> array = new ArrayList<String>();
//      ArrayList<String> dup = new ArrayList<String>();

    File file = new File ("christmas_carol.txt");
    try {

        String fileContent = FileUtils.readFileToString(file);
        String[] lines = fileContent.split(" ");

//          You need not iterate and add instead you can use Arrays.asList. But if its for an exercise this loop is fine. 
//          for (int i = 0 ; i < lines.length; i ++) {
//              array.add(lines[i]);
//          }
//          
//          But better to use for-each loop as
//          for(String line : lines){
//              array.add(line);
//          }

        List<String> array = Arrays.asList(lines);

//          The easiest way to avoid duplicate is to use java.util.Set
        Set<String> uniqueWords = new HashSet<String>(array);

//          But if you want to iterate this logic is wrong. Firstly the dup list is just initialized and empty. So the size is zero and it'll never enter the loop.
//          Secondly dup.equals(lines) is comparing an arraylist with array. That'll always be false
//          for (int i = 0 ; i < dup.size(); i ++){
//              dup.add(line);
//              if (dup.equals(lines)) {
//                  dup.remove(i);
//                  System.out.print(i);
//              }
//          }
//          
//          So what you need here is again a simple loop
        List<String> dup = new ArrayList<String>();
        for(String line : array){
            if(!dup.contains(line)){
                dup.add(line);
            }
        }

//          To find frequency of a word the easiest way is to use a map which keep the word and its count. So when we encounter a duplicate just update the count.
        Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
        int count;
        for(String line : array){
            count = 0;
            if(wordFrequency.containsKey(line)){
                count = wordFrequency.get(line);
            }
            wordFrequency.put(line, ++count);
        }

    } catch (IOException ie) {
        System.err.print("No Such File Found!");
    }

    }
}