/**
     * manage keyboard tabbing, implementing blockindent.
     * @param isUnindent
     */
    private void insertTabChar ( boolean isUnindent ) {

        snapshot (); // snapshot current setup

        if ( isSelection ) { // blockindent