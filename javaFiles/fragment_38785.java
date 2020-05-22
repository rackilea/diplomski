private MemoryUserDB memoryUserDB;

@Test
public void shouldCreateUser(){
   // Arrange
   User user = new User("luca", "antico", "23.11.2011", "112");

   // Act
   User addedUser = memoryUserDB.createUser(user);

   // Assert
   assertEquals(user, addedUser);
   assertEquals(user, memoryUserDB.getByUsername("luca");
}