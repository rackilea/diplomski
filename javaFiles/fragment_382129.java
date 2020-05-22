@Test 
@Transactional
public void testInsert(){ 
    long id=myService.addPerson("JUNIT"); 
    assertNotNull(id); 
    if(id<1){ 
        fail(); 
    } 
}