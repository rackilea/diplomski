public void doSomething(User user, String product) {
   if (cm.containsKey(product)) {
      List<User> list = cm.get(product);
      if (!list.contains(user)) {
         list.add(user);
      }
   }
}