private List<User> filter(List<User> users) {
    final List<User> filtered = new ArrayList<>();
    for(User user : users) {
       if(having(user.getAge(),greaterThan(20)) {
          filtered.add(user);
       }
    }
    return filtered;
}


private boolean having(Integer age,  org.hamcrest.Matcher<Integer> matcher) {

   return matcher.matcher(age);
}