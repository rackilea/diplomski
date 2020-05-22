List results = createQuery(
     "SELECT l FROM login AS l WHERE l.email=:email AND l.password=:password")
     .setParameter("email",login.getEmail())
     .setParameter("password",login.getPassword()).list();
   if (results.isEmpty()) {
     //.. login failed
   } else if (result.size() > 1) {
     throw new SomethingWrongException();
   } else {
     Login login = (Login) results.get(0);
   }