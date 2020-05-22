@Test
    public void createStreamWithSeveralStreamTargetsAndDeleteStream() {
        List<StreamEntity> streamEntities = createStream(1); 

        List<RequestEntity> requestEntitySave = createRequest(1, streamEntityCheck);
        assertEquals(1, requestEntitySave.size()); 

        //you need to clear the persistence context here
        //now a db query should execute.
        //Inject the entitymanager to your test @PersistenceContext EntityManager em;
        em.clear();

        List<StreamEntity> streamEntities = streamDao.findAll();
        assertEquals(1, streamEntities.size());
        StreamEntity streamEntity2 = streamEntities.get(0);
        streamEntity2.getRequestEntities(); - this collection shows 0

   }