package sample.service;
import java.util.Comparator;
import aQute.bnd.annotations.component.*;

@Component
public class SampleComparator implements Comparator {
    public int compare( Object o1, Object o2 ) {
        return o1.equals( o2 ) ? 0 : -1;
    }
}

@Component
class Consumer {
    Comparator comparator;

    public void doCompare( Object o1, Object o2 ) {
      if ( comparator.compare(o1,o2) ) 
        ....
    }

    @Reference
    protected setComparator( Comparator c ) {
       comparator = c;
    }
}