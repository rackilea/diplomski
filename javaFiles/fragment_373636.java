@Test
public void rememberTest()
throws DuplicateException{

    Sighting s1=//initialize s1
    Sighting s2=s1;
    try{
        personA.remember(s1);
    }
    catch (Exception e) {
        fail("Failed" + e.getMessage());
    }
    try{
        personA.remember(s2), //This will throw an exception because s1 and s2 are pointed to the same object
    }
    catch (Exception e) {
        fail("Failed" + e.getMessage());
    }
}