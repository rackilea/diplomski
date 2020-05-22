public void reduce(K key, Iterator<V> values, Context context)
throws IOException {
    V max = values.next();
    while( values.hasNext() ) {
        V current = values.next();
        if( current.compareTo(max) > 0 )
            max = current;
    }
    context.collect(key, max);
}