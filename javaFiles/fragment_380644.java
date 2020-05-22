public static void assertNotNull(String description, Object object){
     try{
          Assert.assertNotNull(description, object);
          System.out.println(description + " - passed");
     }catch(AssertionError e){
          System.out.println(description + " - failed");

        throw e;
     }
}