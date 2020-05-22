package collectiontests.check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListBasedSet<E> {

    private List<E> innerList;

    public ListBasedSet(){
        this(null);
    }

    public ListBasedSet(Collection<E> elements){
        if (elements != null){
            innerList = new ArrayList<E>(elements);
        } else {
            innerList = new ArrayList<E>();
        }
    }

    public void add(E e){
        innerList.add(e);
    }

    public int size(){
        return toSet().size();
    }

    public Iterator<E> iterator(){
        return toSet().iterator();
    }

    public void remove(E e){
        while(innerList.remove(e)); //Keep removing until they are all gone (so set behavior is kept)
    }

    public boolean contains(E e){
        //I think you could just do innerList.contains here as it shouldn't care about duplicates
        return innerList.contains(e);
    }

    private Set<E> toSet(){
        return new HashSet<E>(innerList);
    }
}