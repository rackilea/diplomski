public void testFindWords() {
        // Imagine the user pressed 1 then 2 then 3
        final char[][] chars = {
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
        };
        final Set<String> set = new HashSet<String>();
        append( "", chars, set ); // We enter our recursive method
        for (final String s : set ) {
            System.out.println( "" + s );
        }
        System.out.println( "Set size: " + set.size() );
}