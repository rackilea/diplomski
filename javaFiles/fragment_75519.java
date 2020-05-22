public class SOTest {

    @Test
    public void testFooMethodExists() {
        try {
            Class<SO> clazz = SO.class;
            Method method = clazz.getMethod("foo", String.class);
            Class<?> returnClass = method.getReturnType();
            Assert.assertTrue("foo method returns the wrong type.",
                returnClass.equals(Integer.class));
        } catch (NoSuchMethodException | SecurityException e) {
            Assert.fail("foo method is missing.");
        }
    }

}