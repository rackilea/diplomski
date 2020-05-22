@Autowired SessionFactory sf;

@Test 
@Transactional
public void testInsert(){ 
    myService.addPerson("JUNIT"); 
    sf.getCurrentSession().flush();
    sf.getCurrentSession().doWork( ... check database state ... ); 
}