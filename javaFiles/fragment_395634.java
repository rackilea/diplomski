List<User> sortedUsers = new ArrayList<>();
// group by email-id
Map<String, List<User>> collectMap = 
                 users.stream().collect(Collectors.groupingBy(User::getEmail));

collectMap.entrySet().forEach(e -> {
    String group = e.getValue().stream()                     // collect group names
                               .map(i -> i.getGroup())
                               .collect(Collectors.joining(","));
    User user = e.getValue().get(0);
    sortedUsers.add(new User(user.getName(), user.getEmail(), user.getAge(), group));
});