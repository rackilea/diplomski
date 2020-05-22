package test;
import java.util.ArrayList;
import net.sf.json.JSONObject;
public class Tst {
public static void main(String[] args) {
        ArrayList<String> versuch=new ArrayList<String>();
        for(int i=1; i<11; i++){       
        String temp = "Time1234"+i+",MeanValue123"+i+";";
        System.out.println(temp);
        versuch.add(temp);
        }
        System.out.println(versuch);

        JSONObject jSONString = new JSONObject();
        for (String string:versuch)
        {   //put each string in DBdata to a JSON-Object with key=time and value=value
            jSONString.put(string.substring(0, string.indexOf(",")), string.substring(string.indexOf(",")+1,string.indexOf(";")));
        }
        String output="data.ID=1234."+jSONString.toString();
        System.out.println(output);
        System.out.println(JSONDeconstruct(output));
    }

    public static ArrayList<String> JSONDeconstruct (String st)
    {

        ArrayList<String> out=new ArrayList<String>();

        int begpos=st.indexOf("{");
        int endpos=st.indexOf("}");
        int index=0;

        String work=st.substring(begpos+1, endpos);
        String replaced=work.replace("\",\"", ",");
        work=replaced.replace("\":\"", ":");
        replaced=work.replace("\"","")+",definedend";
        System.out.println(replaced);

        while (!replaced.equals("definedend"))
        {           
            out.add(replaced.substring(0,replaced.indexOf(":"))+","+replaced.substring(replaced.indexOf(":")+1, replaced.indexOf(","))+";");

            String tempstring=replaced.substring(replaced.indexOf(",")+1);  
            replaced=tempstring;
            index++;
            System.out.println("loop disassembly step"+index+"   "+replaced);

        }


        return out;


    }

}