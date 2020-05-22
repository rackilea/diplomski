@Test
public void loadPropertiesFileTestTrue(){
     Utility util=Mockito.mock(Utility.class);

     doThrow(FileNotFoundException.class)
            .when(util)
            .loadPropertiesFile(null);

}