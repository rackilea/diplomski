@Query("select count(m) from MyObject as m where m.user.id = ?#{ principal?.id }")
@Override
long count();

@Modifying
@Query("delete from MyObject as m where m.id = ?1 and m.user.id = ?#{ principal?.id }")
@Override
void delete(Integer integer);

@Modifying
@Query("delete from MyObject as m where m.id = ?1 and m.user.id = ?#{ principal?.id }")
@Override
void delete(MyObject entity);

@Modifying
@Query("delete from MyObject as m where m.user.id = ?#{ principal?.id }")
@Override
void deleteAll();

@Query("select 1 from MyObject as m where m.id = ?1 and m.user.id = ?#{ principal?.id }")
@Override
boolean exists(Integer integer);