package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class EnumValueSortMultiMap<K extends Enum<K>,
    V extends Comparable<? super V>>
    extends AbstractSortedSetMultimap<K, V>{

    private static final long serialVersionUID = 5359491222446743952L;

    private Comparator<? super V> comparator;
    private Class<K> enumType;

    public EnumValueSortMultiMap(){
        this(new HashMap<K, Collection<V>>());
    }

    public EnumValueSortMultiMap(final Comparator<? super V> comparator){
        this(new HashMap<K, Collection<V>>(), comparator);
    }

    public EnumValueSortMultiMap(final Map<K, Collection<V>> map){
        this(map, Ordering.natural());
    }

    public EnumValueSortMultiMap(final Map<K, Collection<V>> map,
        final Comparator<? super V> comparator){
        super(map);
        this.comparator = comparator;
    }

    public EnumValueSortMultiMap(final Class<K> enumClass,
        final Comparator<? super V> comparator){
        this(new EnumMap<K, Collection<V>>(enumClass), comparator);
    }

    public EnumValueSortMultiMap(final Class<K> enumClass){
        this(new EnumMap<K, Collection<V>>(enumClass));
    }

    @Override
    Map<K, Collection<V>> backingMap(){
        return new EnumMap<K, Collection<V>>(enumType);
    }

    @Override
    public Comparator<? super V> valueComparator(){
        return comparator;
    }

    @Override
    SortedSet<V> createCollection(){
        return new TreeSet<V>(comparator);
    }

}