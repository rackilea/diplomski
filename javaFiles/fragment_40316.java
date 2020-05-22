// It is like Integer + !

public class IntegerPlus implements Comparable<IntegerPlus>
{
int value=0;
String id="";

public IntegerPlus(int _val) {value=_val;}
public IntegerPlus(int _val, String _id) {value=_val; id=_id;}

@Override
public String toString() {return value+"("+id+")";}

@Override
public int compareTo(IntegerPlus _other)
    {
    if (value>_other.value) return 1;
    if (value<_other.value) return -1;
    return 0;
    }

}