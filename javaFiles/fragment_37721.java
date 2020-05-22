@Test
    public <T extends Throwable> void testCheckNotNull() {
        try {
        ValidationUtility.checkNotNull(null, "valuename", exceptionClass);
        } catch (T e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
          } 
    }