Object o; // this is the object you want to add to collection
if ( !linkedHashSet.add(o) ) {
    int index = 0;
    for( Object obj : linkedHashSet ) {
        if ( obj == o ) // or obj.equals(o), depending on your code's semantics
            return index;
        index++;
    }
}