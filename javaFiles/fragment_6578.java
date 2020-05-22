public class MyEntityServiceImpl implements MyEntityService{


   public List<MyEntity> findActive() {
      return myEntityRepository.findByActive(true);
   }
}