@Test
public void rememberTest()
throws DuplicateException{

    try{
        personA.remember(sighting4);
    }
    catch (Exception e) {
        fail("Failed" + e.getMessage());
    }
    try{
        personA.remember(sighting3), //this will throws Exception if sighting3 is already in.
    }
    catch (Exception e) {
        fail("Failed" + e.getMessage());
    }
}