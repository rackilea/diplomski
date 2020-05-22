public class Class1Test {
    @Test
    public void test() throws Exception {
        Logger logger = Mockito.mock(Logger.class);
        Mockito.when(logger.isInfoEnabled()).thenReturn(false);
        setFinalStatic(Class1.class.getDeclaredField("LOGGER"), logger);
        Class1 cls1 = new Class1();
        assertFalse(cls1.demoMethod());
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);        
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }
}