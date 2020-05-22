package so;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.*;

public class SOCLass{

     JsonElement job;

     SOCLass(){
         try {
            job = new JsonParser().parse(new FileReader("JSON FILE"));
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }

     boolean isValuePresent(final String v){
         return job.getAsJsonObject().get(v) != null;
     }

     public static void main(String[] args){
         SOCLass so = new SOCLass();
         System.out.println("Is present? " + so.isValuePresent("NO"));
     }

}