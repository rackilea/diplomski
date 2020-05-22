UserDetails userDetails2 = new UserDetails();
userDetails2.setUserName("scott");
userDetails2.setUserId(007);

UserDetails userDetails3 = new UserDetails();
userDetails3.setUserName("toe");
userDetails3.setUserId(101);

Map<String, List<UserDetails>> m = new HashMap<>();
m.put("UserDetails", Arrays.asList(userDetails2, userDetails3));

System.out.print(
    //This is what you need
    objectMapper.writeValueAsString(m)
);
//{"UserDetails":[{"userName":"scott","userId":7},{"userName":"toe","userId":101}]}