import org.json.JSONObject;
import java.util.ArrayList;
import java.io.*;

public class JavaApplication1 {



    public static void main(String[] args) {
        ArrayList<Employee> array = new ArrayList<Employee>();
        for(int i = 0 ; i < 100; i++){
            array.add(new Employee(i+"", i+"", i+""));
        }

        JSONArray jsonArray = new JSONArray();
        for (int i = 0;i < array.size() ; i++) {
            JSONObject obj = new JSONObject();
            JSONObject objItem =  new JSONObject();
            objItem.put("id", array.get(i).getId());
            objItem.put("name",  array.get(i).getName());
            objItem.put("address",  array.get(i).getAddress());
            obj.put("employee", objItem);
            jsonArray.put(obj);
        }

        try (FileWriter file = new FileWriter("your path")) {
            file.write(jsonArray.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonArray);
        } catch(Exception e){
            System.out.println(e);

        }
}

}