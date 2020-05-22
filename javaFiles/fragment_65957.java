Role dbRole = roleRepository.findByRole(user.getRole().getRole());
if(dbRole!=null){
     user.setRole(dbRole);
}

userRepository.save(user);