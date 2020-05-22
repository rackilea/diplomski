public void testisvalid() throws Exception 
    {
        MyHandler handler = new MyHandler();
        Method privateStringMethod = MyHandler.class.getDeclaredMethod("isvalid", Long.class);
        privateStringMethod.setAccessible(true);
        String =  (String) privateStringMethod.invoke(handler, 852l );
        assertNotNull(s);
    }