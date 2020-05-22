private TestDao testDao;

public void setTestDao(TestDao  d){
    this.testDao = d;
}

@Transactional // one transaction for multiple operations
public void someServiceMethod(Collection<BaseDomainModel> data){
     for(BaseDomainModel baseObject : data)
         testDao.saveOrUpdate(baseObject);
}