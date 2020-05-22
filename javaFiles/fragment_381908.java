package com.matt.tester;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;



public class SE {


    public class RangeSet<T extends Long> implements SortedSet<T> {

        private final TreeMap<T, T> backingMap = new TreeMap<T,T>();

        @Override
        public int size() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean contains(Object o) {
            if ( ! ( o instanceof Number ) ) {
                throw new IllegalArgumentException();
            }
            T n = (T) o;
            // Find the greatest backingSet entry less than n
            Map.Entry<T,T> floorEntry = backingMap.floorEntry(n);
            if ( floorEntry == null ) {
                return false;
            }
            final Long endOfRange = floorEntry.getValue();
            if ( endOfRange >= n) {
                return true;
            }
            return false;
        }

        @Override
        public Iterator<T> iterator() {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.  (You'd need a custom Iterator class, I think)");
        }

        @Override
        public Object[] toArray() {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public boolean add(T e) {
            if ( (Long) e < 1L ) {
                throw new IllegalArgumentException("This example only supports counting numbers, mainly because it simplifies printGaps() later on");
            }
            if ( this.contains(e) ) {
                // Do nothing.  Already in set.
            }
            final Long previousEntryKey;
            final T eMinusOne = (T) (Long) (e-1L); 
            final T nextEntryKey = (T) (Long) (e+1L); 
            if ( this.contains(eMinusOne ) ) {
                // Find the greatest backingSet entry less than e
                Map.Entry<T,T> floorEntry = backingMap.floorEntry(e);
                final T startOfPrecedingRange;
                startOfPrecedingRange = floorEntry.getKey();
                if ( this.contains(nextEntryKey) ) {
                    // This addition will join two previously separated ranges
                    T endOfRange = backingMap.get(nextEntryKey);
                    backingMap.remove(nextEntryKey);
                    // Extend the prior entry to include the whole range
                    backingMap.put(startOfPrecedingRange, endOfRange);
                    return true;
                } else {
                    // This addition will extend the range immediately preceding
                    backingMap.put(startOfPrecedingRange,  e);
                    return true;
                }
            } else if ( this.backingMap.containsKey(nextEntryKey) ) {
                // This addition will extend the range immediately following
                T endOfRange = backingMap.get(nextEntryKey);
                backingMap.remove(nextEntryKey);
                // Extend the prior entry to include the whole range
                backingMap.put(e, endOfRange);
                return true;
            } else {
                // This addition is a new range, it doesn't touch any others
                backingMap.put(e,e);
                return true;
            }
        }

        @Override
        public boolean remove(Object o) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public void clear() {
            this.backingMap.clear();
        }

        @Override
        public Comparator<? super T> comparator() {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public SortedSet<T> subSet(T fromElement, T toElement) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public SortedSet<T> headSet(T toElement) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public SortedSet<T> tailSet(T fromElement) {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public T first() {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        @Override
        public T last() {
            throw new IllegalAccessError("Method not implemented.  Left for the reader.");
        }

        public void printGaps() {
            Long lastContiguousNumber = 0L;
            for ( Map.Entry<T, T> entry : backingMap.entrySet() ) {
                Long startOfNextRange = (Long) entry.getKey();
                Long endOfNextRange = (Long) entry.getValue();
                if ( startOfNextRange > lastContiguousNumber + 1 ) {
                    System.out.println( String.valueOf(lastContiguousNumber+1) + ".." + String.valueOf(startOfNextRange - 1) );
                }
                lastContiguousNumber = endOfNextRange;
            }
            System.out.println( String.valueOf(lastContiguousNumber+1) + "..infinity");
            System.out.println("Backing map size is " + this.backingMap.size());
            System.out.println(backingMap.toString());
        }




    }


    public static void main(String[] args) {

        SE se = new SE();

        RangeSet<Long> testRangeSet = se.new RangeSet<Long>();

        // Start by putting 1,000,000 entries into the map with a few, pre-determined, hardcoded gaps
        for ( long i = 1; i <= 1000000; i++ ) {
            // Our pre-defined gaps...
            if ( i == 58349 || ( i >= 87333 && i <= 87777 ) || i == 303998 ) {
                // Do not put these numbers in the set
            } else {
                testRangeSet.add(i);
            }
        }

        testRangeSet.printGaps();

    }
}