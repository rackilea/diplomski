@Override
public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
    User user = new User();
    user.setName("Damian");
    userRepository.save(user);

    user = new User();
    user.setName("Marta");
    userRepository.save(user);

    user = new User();
    user.setName("Natalia");
    userRepository.save(user);

    UGroup uGroup = new UGroup();
    uGroup.setName("Mieszkanie");
    uGroup = uGroupRepository.save(uGroup);

    user = userRepository.findById(1).get();
    user.addGroup(uGroup);
    user = userRepository.save(user);

    // unable to execute

    user = userRepository.findById(2).get();
    user.addGroup(uGroupRepository.findById(4).get());
    user = userRepository.save(user);


    // unable to execute 2

    uGroup = uGroupRepository.findById(4).get();
    uGroup.addUser(userRepository.findById(3).get());
    uGroup = uGroupRepository.save(uGroup);

}