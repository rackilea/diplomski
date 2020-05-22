Iterator<User> it = list.iterator();

while (it.hasNext()) {

  User user = it.next();
  if(user.getName().equals("user1")){
        it.remove();
   }

 }