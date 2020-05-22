import java.util.HashMap;

public class test{

    public static void main(String[] args){

        HashMap<String, String> studentDb = new HashMap<String, String>();

        studentDb.put("1","A");
        studentDb.put("2","B");
        studentDb.put("3","C");

        for(String key : studentDb.keySet()){
            System.out.println(studentDb.get(key));
        }

    }
}