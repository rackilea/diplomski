public Line (final Vector start, final Vector end) {
    if (start.equals (end)) {
        throw new IllegalArgumentException( "Points are the same" );
    }
    this.start = start;
    this.end = end;
    modelLine (start, end);                    
}