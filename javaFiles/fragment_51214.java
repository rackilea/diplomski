import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateInsensitiveCaseString {

    public static void main(String[] args) {
      List<String> list =  Arrays.asList("abort", "Abort", "accent", "ACCENT");
      Set<String> set = list.stream().map(String::toUpperCase).collect(Collectors.toSet());     
      if (set.size() != list.size()){
        // you have duplicate
        System.out.println(set);
      }
    }
}