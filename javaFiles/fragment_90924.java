@Override
public User getByUserName(String name) {
    User u = userRepository.findByUserName(name);
    Hibernate.initialize(u.getUserRole());
    return u;
}