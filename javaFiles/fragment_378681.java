FullTextEntityManager ftEntityManager = Search.getFullTextEntityManager( em );
SearchFactory searchFactory = ftEntityManager.getSearchFactory();

// get the integrator from the search factory
SearchIntegator integrator = searchFactory.unwrap( SearchIntegrator.class );
for ( Class<?> indexType : integrator.getIndexedTypes() ) {
   EntityIndexBinding binding = integrator.getIndexBinding( indexType );
   for( IndexManager indexManager : binding.getIndexManagers() ) {
     // do whatever you need here
   }
}