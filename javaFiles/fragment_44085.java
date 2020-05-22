//1. Save user to DB, this will give it ID  
userDao.insert(bill);  

//2. Set user entity with ID to its relational entities  
billsPicture.setUser(bill);  
billsAddress.setUser(bill);  

//3. Save relational entities  
pictureDao.insert(billsPicture);  
addressDao.insert(billsAddress);