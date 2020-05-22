package util;

import java.util.Iterator;

import net.sf.json.JSONArray;

import org.apache.velocity.util.introspection.Info;
import org.apache.velocity.util.introspection.SecureUberspector;

/**
 * Customized Velocity introspector.  Used so that FML can iterate through JSON arrays.
 */
public class CustomUberspector extends SecureUberspector
{
    @Override
    @SuppressWarnings("rawtypes")
    public Iterator getIterator(Object obj, Info i) throws Exception
    {
        if (obj instanceof JSONArray)
        {
            return new JsonArrayIterator((JSONArray) obj);
        }
        else
        {
            return super.getIterator(obj, i);
        }
    }
}