package collectiontests.check;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class ChangeDetectingSet<E> extends TreeSet<E> {

    private boolean compacting = false;

    @SuppressWarnings("unchecked")
    private void compact(){
        //To avoid infinite loops, make sure we are not already compacting (compact also gets called in the methods used here)
        if(!compacting){ //Warning: this is not thread-safe
            compacting = true;
            Object[] elements = toArray();
            clear();
            for(Object element: elements){
                add((E)element); //Yes unsafe cast, but we're rather sure
            }
            compacting = false;
        }
    }
    @Override
    public boolean add(E e) {
        compact();
        return super.add(e);
    }
    @Override
    public Iterator<E> iterator() {
        compact();
        return super.iterator();
    }
    @Override
    public Iterator<E> descendingIterator() {
        compact();
        return super.descendingIterator();
    }
    @Override
    public NavigableSet<E> descendingSet() {
        compact();
        return super.descendingSet();
    }
    @Override
    public int size() {
        compact();
        return super.size();
    }
    @Override
    public boolean isEmpty() {
        compact();
        return super.isEmpty();
    }
    @Override
    public boolean contains(Object o) {
        compact();
        return super.contains(o);
    }
    @Override
    public boolean remove(Object o) {
        compact();
        return super.remove(o);
    }
    @Override
    public void clear() {
        compact();
        super.clear();
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        compact();
        return super.addAll(c);
    }
    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        compact();
        return super.subSet(fromElement, fromInclusive, toElement, toInclusive);
    }
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        compact();
        return super.headSet(toElement, inclusive);
    }
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        compact();
        return super.tailSet(fromElement, inclusive);
    }
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        compact();
        return super.subSet(fromElement, toElement);
    }
    @Override
    public SortedSet<E> headSet(E toElement) {
        compact();
        return super.headSet(toElement);
    }
    @Override
    public SortedSet<E> tailSet(E fromElement) {
        compact();
        return super.tailSet(fromElement);
    }
    @Override
    public Comparator<? super E> comparator() {
        compact();
        return super.comparator();
    }
    @Override
    public E first() {
        compact();
        return super.first();
    }
    @Override
    public E last() {
        compact();
        return super.last();
    }
    @Override
    public E lower(E e) {
        compact();
        return super.lower(e);
    }
    @Override
    public E floor(E e) {
        compact();
        return super.floor(e);
    }
    @Override
    public E ceiling(E e) {
        compact();
        return super.ceiling(e);
    }
    @Override
    public E higher(E e) {
        compact();
        return super.higher(e);
    }
    @Override
    public E pollFirst() {
        compact();
        return super.pollFirst();
    }
    @Override
    public E pollLast() {
        compact();
        return super.pollLast();
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        compact();
        return super.removeAll(c);
    }
    @Override
    public Object[] toArray() {
        compact();
        return super.toArray();
    }
    @Override
    public <T> T[] toArray(T[] a) {
        compact();
        return super.toArray(a);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        compact();
        return super.containsAll(c);
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        compact();
        return super.retainAll(c);
    }
    @Override
    public String toString() {
        compact();
        return super.toString();
    }
}