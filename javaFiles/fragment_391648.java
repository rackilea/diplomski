public class RegExHashSet extends HashSet<String > {
    public boolean containsRegEx( String regex ) {
        for( String string : this ) {
            if( string.matches( regex ) ) {
                return true;
            }
        }
        return false;
    }
}