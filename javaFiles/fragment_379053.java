@Autowired
private ApplicationContext applicationContext;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public void doSomeWork(){
 Entity = entity = dao.loadEntity();
 // do some related work
 ...
 try {
  dao.saveEntity(entity);
 }
 catch(StaleObjectStateException sose){
  dao.flush(entity);
  applicationContext.getBean(this.getClass()).doSomeWork();
 }
}