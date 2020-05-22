@Test
public void setMyentityAOfTeIfNullByLanr17() {
    MyentityB entityB = new MyentityB(...) ;
    entityB.setLanr7( "1234567" );
    final MyentityA myentityA = new MyentityA();
    mockito.when( myentityAServiceImplmock.findMyentityAByLanr17( entityB.getLanr7() ) ).thenReturn( myentityA );
    mockito.when( myentityBdaomock.save(entityB) ).thenReturn(entityB);

    // action
    MyentityB entityActualB = teServiceImpl.setMyentityAOfTeIfNullByLanr17(entityB);

    // Perform content/logic assertion and no flow assertion :
    Assertions.assertEquals(myEntityA, entityActualB.getMyEntityA());
    Assertions.assertEquals("root", entityActualB.getModuser());
}