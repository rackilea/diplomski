Session session = null;
try {
    session = ... // acquire the session
    // use the session, including 0 or more calls to 'save()'
} catch ( RepositoryException e ) {
    // handle it
} finally {
   if ( session != null ) session.logout();
}