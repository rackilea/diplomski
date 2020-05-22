import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seq {

    public static void main(String[] args) {
        String str = "TRANS = 2'b00 to 2'b11"; 
        Matcher matcher = Pattern.compile("2'b\\s*(\\w+)").matcher(str);
        List<String> range = new ArrayList<String>();
        while (matcher.find()) {
            range.add(matcher.group(1));
        }
        if(range.size() == 2){
            List<String> output = new ArrayList<String>();
            int start = Integer.parseInt(range.get(0),2);
            int end = Integer.parseInt(range.get(1),2);
            for(int i=start; i<=end; i++){
                output.add("2'b" + String.format("%02d", Integer.parseInt(Integer.toBinaryString(i))));
            }
            System.out.println(output); // Prints [2'b00, 2'b01, 2'b10, 2'b11]
        }
    }
}