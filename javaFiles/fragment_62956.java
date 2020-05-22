int = flushAfterThisNumber = 10;

for ( int i=0; i<entities.length; i++ ) {
    session.save(entities[i]);
    if ( i % flushAfterThisNumber == 0 ) { 
        //flush a batch of inserts and release memory:
        session.flush();
        session.clear();
    }
}