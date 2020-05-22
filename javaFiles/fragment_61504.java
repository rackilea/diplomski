package myutil;

import java.util.Iterator;

import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringEscapeUtils;

public class JSONCleaner {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JSONObject jsonchild2=new JSONObject();
        jsonchild2.put("subchlidkey1", "subchildvalue1");
        jsonchild2.put("subchlidkey2", "subchildvalue2");
        jsonchild2.put("subchlidkey3", "subchildvalue3");

        JSONObject jsonchild=new JSONObject();
        jsonchild.put("chlidkey1", "childvalue1");
        jsonchild.put("chlidkey2", "childvalue2");
        jsonchild.put("chlidkey3", "childvalue3");

        JSONArray jsonarray=new JSONArray();
        jsonarray.add("option1");
        jsonarray.add("<p>option2</p>");
        jsonarray.add(jsonchild2);

        JSONObject json=new JSONObject();
        json.put("name", "<b>nirbhay</b>");
        json.put("age", 23);
        json.put("jsonChildObject", jsonchild);
        json.put("weight", 65);
        json.put("array", jsonarray);

        System.out.println(cleanJSONObject(json));
        //System.out.println(json.getString("name"));
    }

    public static JSONObject cleanJSONObject(JSONObject jsonObject)
    {
        JSONObject returnJson=new JSONObject();
        Iterator<?> keys = jsonObject.keys();
        while( keys.hasNext() ){
            String key = (String)keys.next();
            //System.out.println(jsonObject.get(key));
            if(jsonObject.optJSONObject(key)==null)
            {
                if(jsonObject.optJSONArray(key)!=null)
                {
                returnJson.put(key, cleanJSONArray(jsonObject.getJSONArray(key)));
                }
                else
                {
                    returnJson.put(key, StringEscapeUtils.escapeHtml(jsonObject.getString(key)));
                }
            }
            else
            {
                returnJson.put(key,cleanJSONObject(jsonObject.optJSONObject(key)));
            }
        }

        return returnJson;
    }

    private static JSONArray cleanJSONArray(JSONArray array)
    {

        JSONArray returnArray=new JSONArray();
        for(int i=0,j=array.size();i<j;i++)
        {
            if(array.optJSONObject(i)==null)
            {
                if(array.optJSONArray(i) != null)
                {
                returnArray.add(cleanJSONArray((JSONArray) array.get(i)));
                }
                else
                {
                    returnArray.add(StringEscapeUtils.escapeHtml(array.getString(i)));
                }
            }
            else
            {
                returnArray.add(cleanJSONObject((JSONObject) array.get(i)));
            }

        }
        return returnArray;
    }
}