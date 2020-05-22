import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class JAXBListPrimitiveUtils
{

  @SuppressWarnings("unchecked")
  public static <T> List<T> JSONArrayToList(JSONArray array)
  {
    List<T> list = new ArrayList<T>();
    try
    {
      for (int i = 0; i < array.length(); i++)
      {
        list.add( (T)array.get(i) );
      }
    }
    catch (JSONException e)
    {
      java.util.logging.Logger.getLogger(JAXBListPrimitiveUtils.class.getName()).warning("JAXBListPrimitiveUtils :Problem while converting JSONArray to arrayList" + e.toString());
    }

    return list;
  }

  @SuppressWarnings("rawtypes")
  public static JSONArray listToJSONArray(List list)
  {
    return new JSONArray(list);
  }
}