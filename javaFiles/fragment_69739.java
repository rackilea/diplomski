@Test
public void testMyAction() {
    running(fakeApplication(), new Runnable() {
        public void run() {                
            Map<String,String> data = new HashMap<String, Object>();
            data.put("param1", "test-1");
            data.put("param2", "test-2");
            data.put("file", file);

            Result result = callAction(
                controllers.whatever.action(),
                fakeRequest().withFormUrlEncodedBody(data)
            )
            ...
         }
     }
}