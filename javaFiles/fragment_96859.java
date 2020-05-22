List<List<String>> listOfLists = ...;
for( List<String> list: listOfLists ){
    String el;
    if( list.size() > 14 &&              // list is long enough
        (el = list.get(14)) != null ){   // element is not null
        list.set( 12, el );              // replace element at index 12
    }  
}