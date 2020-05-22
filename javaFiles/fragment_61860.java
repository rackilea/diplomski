static <T> List<List<T>> combinations( List<T> list, int n ){

    List<List<T>> result;

    if( list.size() <= n ){

        result = new ArrayList<List<T>>();
        result.add( new ArrayList<T>(list) );

    }else if( n <= 0 ){

        result = new ArrayList<List<T>>();
        result.add( new ArrayList<T>() );

    }else{

        List<T> sublist = list.subList( 1, list.size() );

        result = combinations( sublist, n );

        for( List<T> alist : combinations( sublist, n-1 ) ){
            List<T> thelist = new ArrayList<T>( alist );
            thelist.add( list.get(0) );
            result.add( thelist );
        }
    }

    return result;
}