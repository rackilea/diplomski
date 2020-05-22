public void kick( String username ) {
    for( int i = 0 ; i < MAX_CLIENTS ; i++ ) {
        if ( this.m_clients[ i ].getUsername().equals( username ) {
            this.m_clients[ i ].close();
            this.m_clients[ i ] = null;
        }
    }
}