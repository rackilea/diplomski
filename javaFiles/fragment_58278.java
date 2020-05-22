class Token {
    String word;
    List<RefCount> references;
    ...

    public void countWord( String fileId ){
        int last = references.size() - 1;
        if( last >= 0 ){
            RefCount rc =  references.get(last);
            if( equals(fileId) ){
                rc.increment();
                return;
            }
        }
        references.add( fileId );
    }
    // more...
}