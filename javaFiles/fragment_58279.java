for( Token token: tokenList ){
    System.out.print( token.getWord() + ":" );
    for( RefCount refCount: token.getReferences() ){
        System.out.print( " " + refCount.getFileId() +
                          "*" + refCount.getCount() );
    }
    System.out.println();
}