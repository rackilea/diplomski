beginTransaction();
House house = houseDao.find(1L);
commitTransaction()


... your magic

Person person = new Person(house,"Dilbert");

session.saveOrUpdate(person);