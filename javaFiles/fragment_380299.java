public class TempTest
{
    static class CertainObject
    {
        private String param;
        String getParam() { return param; }
        void setParam(String p) { param = p; }
    }

    public interface Service { String execute(CertainObject o); }

    public static class ToTest
    {
        private Service service;

        public String make()
        {
            CertainObject obj = new CertainObject();
            obj.setParam("a");
            String inverted = service.execute(obj);
            return "<" + inverted + ">";
        }
    }

    @Tested ToTest toTest;
    @Injectable Service service;

    @Test
    public void temp()
    {
         new NonStrictExpectations() {{
             service.execute((CertainObject) any);
             result = "b";
         }};

         toTest.make();

         new Verifications() {{
             CertainObject obj;
             service.execute(obj = withCapture());
             assertEquals("a", obj.getParam());
         }};
    }
}