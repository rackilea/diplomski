public void updateUsers(List<Long> userIds) {
   for (Long i : userIds) {
      User user = userRepository.findById(i);
         if(user != null){
            user.setIsActive(9L);
            user.setUserName("Update Test");
            // call your update method here (this is not stated in your code)
         }
    }
}