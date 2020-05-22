@Transactional
public void someMethod() {

  try (Stream<User> stream = repository.findAllByCustomQueryAndStream()) {
    stream.forEach(…);
  } 
}