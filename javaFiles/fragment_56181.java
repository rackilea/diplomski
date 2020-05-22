import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class Bag<E> 
{
    private Map<E, Integer> m_values;

    public Bag()
    {
        m_values = new TreeMap<E, Integer>();
    }

    public Bag(Iterable<E> arr)
    {
        this();
        for(E v : arr)
        {
            add(v);
        }
    }

    public Bag(Bag<E> b)
    {
        this();
        for(E v : b.values())
        {
            set(v, b.count(v));
        }
    }

    public void add(E v)
    {
        Integer count = m_values.get(v);
        m_values.put(v, count == null ? 1 : count+1);
    }

    public void add(Bag<E> b)
    {
        for(E v : b.values())
        {
            Integer count = m_values.get(v);
            m_values.put(v, count == null ? b.count(v) : count+b.count(v));
        }
    }

    public void remove(E v)
    {
        Integer count = m_values.get(v);
        if(count == null) throw new NoSuchElementException();
        if(count == 1)
            m_values.remove(v);
        else
            m_values.put(v, count-1);
    }

    public void remove(Bag<E> b)
    {
        for(E v : b.values())
        {
            Integer count = m_values.get(v);    
            Integer bcount = b.count(v);
            if(count == null || count < bcount) throw new NoSuchElementException();
            if(count == bcount)
                m_values.remove(v);
            else
                m_values.put(v, count-bcount);
        }
    }

    public boolean contains(Bag<E> b)
    {
        for(E v : b.values())
        {
            if(count(v) < b.count(v)) return false;
        }
        return true;
    }

    public void set(E v, int count)
    {
        if(count == 0)
            m_values.remove(v);
        else
            m_values.put(v, count);
    }

    public int count(E v)
    {
        Integer count = m_values.get(v);
        return count == null ? 0 : count;
    }

    public Iterable<E> values()
    {
        return m_values.keySet();
    }

    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append("[");
        for(E v : values())
        {
            for(int i=0; i<count(v); i++)
            {
                b.append(v + " ");
            }
        }
        b.deleteCharAt(b.length()-1);
        b.append("]");
        return b.toString();
    }
}