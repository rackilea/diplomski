UserDAO userDao; //some injection or lookup

 //no explicit cast needed here, thanks to generics
 UserEntity user = userDao.findById(userId);

 //compiler error due to the generic parameter being UserEntity and AnotherEntity doesn't extend that
 AnotherEntity a = userDao.findById(someId);