@Override
public void release(Statement statement) {
    :
    :
    final Set<ResultSet> resultSets = xref.get( statement );
    if ( resultSets != null ) {
        closeAll( resultSets );
    }
        xref.remove( statement );
    }
    close( statement );
}