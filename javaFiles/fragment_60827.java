// MyEntityDao is your server service for MyEntity
@Service(value = MyEntityDao.class, locator = MyServiceLocator.class) 
interface MyEntityRequestContext extends RequestContext { 
Request<List<MyEntityProxy>> listAll();
Request<Void> save(MyEntityProxy entity);
... 
}