@Test
public void testMyMethod(@Mocked final USERS_DB user){

new Expectations(){
             {
              user.authenticate(connection, userName, password);
              result = true/false/Exception();
            }};
}