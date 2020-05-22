public class MyAmazingClassTest extends WithApplication {

    @Test
    public void testMyAmazingMethodHandlingForms() throws Exception {
        Map<String, String> formData = new HashMap<>();
        formData.put("some", "value");
        // fill the form with the test data
        Http.RequestBuilder fakeRequest = Helpers.fakeRequest().bodyForm(formData).method(Helpers.POST);

        Result result = Helpers.route(app, fakeRequest);

        // make assertions over the result or something else.
    }
}