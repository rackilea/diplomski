===
Tuple.java
===
package com.stackoverflow.tuple;

/**
 * Tuple are immutable objects.  Tuples should contain only immutable objects or
 * objects that won't be modified while part of a tuple.
 */
public interface Tuple {

    public TupleType getType();
    public int size();
    public <T> T getNthValue(int i);

}


===
TupleType.java
===
package com.stackoverflow.tuple;

/**
 * Represents a type of tuple.  Used to define a type of tuple and then
 * create tuples of that type.
 */
public interface TupleType {

    public int size();

    public Class<?> getNthType(int i);

    /**
     * Tuple are immutable objects.  Tuples should contain only immutable objects or
     * objects that won't be modified while part of a tuple.
     *
     * @param values
     * @return Tuple with the given values
     * @throws IllegalArgumentException if the wrong # of arguments or incompatible tuple values are provided
     */
    public Tuple createTuple(Object... values);

    public class DefaultFactory {
        public static TupleType create(final Class<?>... types) {
            return new TupleTypeImpl(types);
        }
    }

}


===
TupleImpl.java (not visible outside package)
===
package com.stackoverflow.tuple;

import java.util.Arrays;

class TupleImpl implements Tuple {

    private final TupleType type;
    private final Object[] values;

    TupleImpl(TupleType type, Object[] values) {
        this.type = type;
        if (values == null || values.length == 0) {
            this.values = new Object[0];
        } else {
            this.values = new Object[values.length];
            System.arraycopy(values, 0, this.values, 0, values.length);
        }
    }

    @Override
    public TupleType getType() {
        return type;
    }

    @Override
    public int size() {
        return values.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getNthValue(int i) {
        return (T) values[i];
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)   return false;
        if (this == object)   return true;

        if (! (object instanceof Tuple))   return false;

        final Tuple other = (Tuple) object;
        if (other.size() != size())   return false;

        final int size = size();
        for (int i = 0; i < size; i++) {
            final Object thisNthValue = getNthValue(i);
            final Object otherNthValue = other.getNthValue(i);
            if ((thisNthValue == null && otherNthValue != null) ||
                    (thisNthValue != null && ! thisNthValue.equals(otherNthValue))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (Object value : values) {
            if (value != null) {
                hash = hash * 37 + value.hashCode();
            }
        }
        return hash;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}


===
TupleTypeImpl.java (not visible outside package)
===
package com.stackoverflow.tuple;

class TupleTypeImpl implements TupleType {

    final Class<?>[] types;

    TupleTypeImpl(Class<?>[] types) {
        this.types = (types != null ? types : new Class<?>[0]);
    }

    public int size() {
        return types.length;
    }

    //WRONG
    //public <T> Class<T> getNthType(int i)

    //RIGHT - thanks Emil
    public Class<?> getNthType(int i) {
        return types[i];
    }

    public Tuple createTuple(Object... values) {
        if ((values == null && types.length == 0) ||
                (values != null && values.length != types.length)) {
            throw new IllegalArgumentException(
                    "Expected "+types.length+" values, not "+
                    (values == null ? "(null)" : values.length) + " values");
        }

        if (values != null) {
            for (int i = 0; i < types.length; i++) {
                final Class<?> nthType = types[i];
                final Object nthValue = values[i];
                if (nthValue != null && ! nthType.isAssignableFrom(nthValue.getClass())) {
                    throw new IllegalArgumentException(
                            "Expected value #"+i+" ('"+
                            nthValue+"') of new Tuple to be "+
                            nthType+", not " +
                            (nthValue != null ? nthValue.getClass() : "(null type)"));
                }
            }
        }

        return new TupleImpl(this, values);
    }
}


===
TupleExample.java
===
package com.stackoverflow.tupleexample;

import com.stackoverflow.tuple.Tuple;
import com.stackoverflow.tuple.TupleType;

public class TupleExample {

    public static void main(String[] args) {

        // This code probably should be part of a suite of unit tests
        // instead of part of this a sample program

        final TupleType tripletTupleType =
            TupleType.DefaultFactory.create(
                    Number.class,
                    String.class,
                    Character.class);

        final Tuple t1 = tripletTupleType.createTuple(1, "one", 'a');
        final Tuple t2 = tripletTupleType.createTuple(2l, "two", 'b');
        final Tuple t3 = tripletTupleType.createTuple(3f, "three", 'c');
        final Tuple tnull = tripletTupleType.createTuple(null, "(null)", null);
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);
        System.out.println("tnull = " + tnull);

        final TupleType emptyTupleType =
            TupleType.DefaultFactory.create();

        final Tuple tempty = emptyTupleType.createTuple();
        System.out.println("\ntempty = " + tempty);

        // Should cause an error
        System.out.println("\nCreating tuple with wrong types: ");
        try {
            final Tuple terror = tripletTupleType.createTuple(1, 2, 3);
            System.out.println("Creating this tuple should have failed: "+terror);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace(System.out);
        }

        // Should cause an error
        System.out.println("\nCreating tuple with wrong # of arguments: ");
        try {
            final Tuple terror = emptyTupleType.createTuple(1);
            System.out.println("Creating this tuple should have failed: "+terror);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace(System.out);
        }

        // Should cause an error
        System.out.println("\nGetting value as wrong type: ");
        try {
            final Tuple t9 = tripletTupleType.createTuple(9, "nine", 'i');
            final String verror = t9.getNthValue(0);
            System.out.println("Getting this value should have failed: "+verror);
        } catch (ClassCastException ex) {
            ex.printStackTrace(System.out);
        }

    }

}

===
Sample Run
===
t1 = [1, one, a]
t2 = [2, two, b]
t3 = [3.0, three, c]
tnull = [null, (null), null]

tempty = []

Creating tuple with wrong types: 
java.lang.IllegalArgumentException: Expected value #1 ('2') of new Tuple to be class java.lang.String, not class java.lang.Integer
    at com.stackoverflow.tuple.TupleTypeImpl.createTuple(TupleTypeImpl.java:32)
    at com.stackoverflow.tupleexample.TupleExample.main(TupleExample.java:37)

Creating tuple with wrong # of arguments: 
java.lang.IllegalArgumentException: Expected 0 values, not 1 values
    at com.stackoverflow.tuple.TupleTypeImpl.createTuple(TupleTypeImpl.java:22)
    at com.stackoverflow.tupleexample.TupleExample.main(TupleExample.java:46)

Getting value as wrong type: 
java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
    at com.stackoverflow.tupleexample.TupleExample.main(TupleExample.java:58)