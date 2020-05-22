import java.io.UnsupportedEncodingException;

public class ReplaceI18N {

    public static void main(String[] args) {
        String[] names = {
                "John Smith",
                "高岡和子",
                "محمد سعيد بن عبد العزيز الفلسطيني",                
                "|J:o<h>n?Sm\\it/h*", 
                "高?岡和\\子*", 
                "محمد /سعيد بن عبد ?العزيز :الفلسطيني\\"
                };

        for(String s: names){
            String u  = s;
            try {
                u = new String(s.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            u = u.replaceAll("[\\?\\\\/:|<>\\*]", " "); //filter ? \ / : | < > *
            u = u.replaceAll("\\s+", "_");
            System.out.println(s + " = " + u);
        }
    }
}