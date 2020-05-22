public void updateUser(User user) {
    User entity = userRepository.findById(user.getId()).orElse(null);
    //Check if the intended record exists. If exists, update it..
    if (entity != null) {
        System.out.println("\nUpdating User- " + user.getUsername() + "\n");
        entity.setUsername(user.getUsername());
        entity.setUseremail(user.getUseremail());
        entity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }
    // And finally save it...
    userRepository.save(entity);
}