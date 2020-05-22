package collectiontests.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class ChangeDetectingSet<E extends Observable> implements Set<E>, Observer {

    private HashSet<E> innerSet;

    public void update(Observable o, Object arg) {
        innerSet.remove(o);
        innerSet.add((E)o); 
    }
    public int size() {
        return innerSet.size();
    }
    public boolean isEmpty() {
        return innerSet.isEmpty();
    }
    public boolean contains(Object o) {
        return innerSet.contains(o);
    }
    public Iterator<E> iterator() {
        return innerSet.iterator();
    }
    public Object[] toArray() {
        return innerSet.toArray();
    }
    public <T> T[] toArray(T[] a) {
        return innerSet.toArray(a);
    }
    public boolean add(E e) {
        e.addObserver(this);
        return innerSet.add(e);
    }
    public boolean remove(Object o) {
        if(o instanceof Observable){
            ((Observable) o).deleteObserver(this);
        }
        return innerSet.remove(o);
    }
    public boolean containsAll(Collection<?> c) {
        return innerSet.containsAll(c);
    }
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E el: c){
            result = result || add(el);
        }
        return result;
    }
    public boolean retainAll(Collection<?> c) {
        Iterator<E> it = innerSet.iterator();
        E el;
        Collection<E> elementsToRemove = new ArrayList<E>();
        while(it.hasNext()){
            el = it.next();
            if(!c.contains(el)){
                elementsToRemove.add(el); //No changing the set while the iterator is going. Iterator.remove may not do what we want.
            }
        }
        for(E e: elementsToRemove){
            remove(e);
        }
        return !elementsToRemove.isEmpty(); //If it's empty there is no change and we should return false
    }
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for(Object e: c){
            result = result || remove(e);
        }
        return result;
    }
    public void clear() {
        Iterator<E> it = innerSet.iterator();
        E el;
        while(it.hasNext()){
            el = it.next();
            el.deleteObserver(this);
        }
        innerSet.clear();
    }
}