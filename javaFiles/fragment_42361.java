package com.example.model;    

import java.text.Collator;
import java.util.Comparator;

public class CustomComparator implements Comparator
{

    private Collator collator;

    public CustomComparator()
    {
        this(Collator.getInstance());
    }

    public CustomComparator(Collator collatorToUse)
    {
        this.collator = collatorToUse;
        this.collator.setStrength(0);
    }

    public int compare(Object object1, Object object2)
    {
        int returnValue;
        if ((object1 instanceof String) && (object2 instanceof String))
        {
            returnValue = this.collator.compare(object1, object2);
        }
        else
        {
            if ((object1 instanceof Comparable) && (object2 instanceof Comparable))
            {
                returnValue = ((Comparable) object1).compareTo(object2);
            }
            else
            {
                returnValue = this.collator.compare(object1.toString(), object2.toString());
            }
        }
        return -returnValue;
    }

}