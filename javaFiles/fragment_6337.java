Mockito.when(avisDao.existsPortalContingut(AvisPortal.class.cast(Matchers.anyObject()))).thenAnswer(new Answer<Boolean>(){

        @Override
        public Boolean answer(InvocationOnMock invocation) throws Throwable {
            return true;
        }        
    });