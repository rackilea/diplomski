while(itr.hasNext()) {
    T foo = itr.next();
    //do the comparison
    if ( ... ) { // using foo
        itr.remove();
    }
}