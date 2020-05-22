import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;    
   public class Main {
        public static void main(String[] args) throws Exception{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstLine = reader.readLine();
            int numOfRowsToFollow = Integer.parseInt(firstLine);
            Map<Integer,Set<String>> stringsByLength = new HashMap<>(numOfRowsToFollow); //worst-case size
            for (int i=0; i<numOfRowsToFollow; i++) {
                String line = reader.readLine();
                int length = line.length();
                Set<String> alreadyUnderThatLength = stringsByLength.get(length); //int boxed to Integer
                if (alreadyUnderThatLength==null) {
                    alreadyUnderThatLength = new HashSet<>();
                    stringsByLength.put(length, alreadyUnderThatLength);
                }
                alreadyUnderThatLength.add(line);
            }
            System.out.println("results: "+stringsByLength);
        }
    }