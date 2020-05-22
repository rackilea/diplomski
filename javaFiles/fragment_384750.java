class CartesianIterator <T> implements Iterator <List <T>> {

    private final List <List <T>> lilio;    
    private int current = 0;
    private final long last;

    public CartesianIterator (final List <Set <T>> llo) {
    // transform Set<T> to List <T>, because we need an index later
        List <List <T>> llt = new ArrayList <List <T>> ();    
        for (Set <T> st : llo)
        {
        List <T> lt = new ArrayList <T> ();
        for (T t: st)
            lt.add (t);
        llt.add (lt);
    }
        lilio = llt;
        long product = 1L;
        for (List <T> lio: lilio)
            product *= lio.size ();
        last = product;
    } 

    public boolean hasNext () {
        return current != last;
    }

    public List <T> next () {
        ++current;
        return get (current - 1, lilio);
    }

    public void remove () {
        ++current;
    }

    private List<T> get (final int n, final List <List <T>> lili) {
        switch (lili.size ())
        {
            case 0: return new ArrayList <T> (); // no break past return;
            default: {
                List <T> inner = lili.get (0);
                List <T> lo = new ArrayList <T> ();
                lo.add (inner.get (n % inner.size ()));
                lo.addAll (get (n / inner.size (), lili.subList (1, lili.size ())));
                return lo;
            }
        }
    }
}

class CartesianIterable <T> implements Iterable <List <T>> {

    private List <Set <T>> lilio;  

    public CartesianIterable (List <Set <T>> llo) {
        lilio = llo;
    }

    public Iterator <List <T>> iterator () {
        return new CartesianIterator <T> (lilio);
    }
}

public class SetItTest 
{
    public static void main ( String [] args )
    {
        Set <Integer> si = new HashSet<Integer> ();
        si.add (1);
        si.add (2);
        List <Set<Integer>> ls = new ArrayList <Set<Integer>> ();
        ls.add (si);
        ls.add (si);
        ls.add (si);
        CartesianIterable <Integer> ci = new CartesianIterable <Integer> (ls); 
        for (List <Integer> li : ci) 
        {
            for (int i : li)
                System.out.print (i + " ");
            System.out.println ();
        }
    }
}