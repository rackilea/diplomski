public Object initializeLazyProperty(String fieldName, Object entity,
                          SessionImplementor session) throws HibernateException {

   final Serializable id = session.getContextEntityIdentifier( entity );

   final EntityEntry entry = session.getPersistenceContext().getEntry( entity );

   if ( entry == null ) {
      throw new
          HibernateException("entity is not associated with the session: " + id);
   }
   ...