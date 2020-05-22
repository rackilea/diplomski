@Override
public List<T> getListByPage(int maxResults, int pageNumber) {
    List<T> list = getList();

    if( list.size() > maxResults ) {
        list = list.subList( 0, maxResults );
    }

    int start = pageNumber * pageSize;
    int end = Math.min( start + pageSize, list.size() );

    if( list.size() < start ) {
        list = new ArrayList<T>();
    } else {
        list = list.subList( start, end );
    }

    return list;
}