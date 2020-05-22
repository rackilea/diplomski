package util;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

public class JsonArrayIterator implements Iterator<Object>
{
    private final JSONArray array;
    private int nextIndex;
    private final int length;

    public JsonArrayIterator(JSONArray array)
    {
        this.array = array;
        nextIndex = 0;
        length = array.size();
    }

    @Override
    public boolean hasNext()
    {
        return nextIndex < length;
    }

    @Override
    public Object next()
    {
        nextIndex++;
        try
        {
            return array.get(nextIndex - 1);
        }
        catch (JSONException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }


}