import org.json.*;
public class CreateMyJSON
{
    public static void main(String[] args)
    {
        String testData = "ps:mandatory\nProperties\n\nps:Source:\n    f47437\n\nps:Created:\n    2010-09-03T11:38:02.629Z\n\nps:ChangedBy:\n    F47437\n\nps:Changed:\n    2011-09-07T07:51:10.864Z\n\n";
        CreateMyJSON cmj = new CreateMyJSON();
        System.out.println(cmj.getJSONFromString(testData));
        }

    public String getJSONFromString(String theData)
    {   
        JSONObject jso = new JSONObject();
        //no error checking, but replacing double returns
        //to make this simpler
        String massagedData = theData.replaceAll("\n\n", "\n");
        String[] splits = massagedData.split("\n");
        for(int i = 0; i < splits.length; i++)
        {
            jso.put(splits[i].trim(), splits[++i].trim());
        }

        return jso.toString();
    }
}