public class MyAmazingClassTest {

    @Test
    public void testMyAmazingMethodHandlingForms() throws Exception {
        Form<String> form = mock(Form.class);
        // setup the mocked form as you expect it to behave

        FormFactory formFactory = mock(FormFactory.class);
        when(formFactory.form(eq(String.class)).bindFromRequest()).thenReturn(form);

        MyAmazingClass myAmazingClass = new MyAmazingClass(formFactory);
        myAmazingClass.myAmazingMethodHandlingForms();

        // Some assertions...
    }
}