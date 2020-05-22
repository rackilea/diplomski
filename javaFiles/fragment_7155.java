public class ServiceClass {..

@Transactional
public void updateDatabase(..) {
  jpaDao.remove(..);
  jdbcDao.insert(..);
}
}