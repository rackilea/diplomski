User user = new User();  // Ignoring the constructor parameters...
UserDetail userDetail = new UserDetail();  

user.setUserDetail(userDetail);
userDetail.setUser(user);

userRepository.save(user);