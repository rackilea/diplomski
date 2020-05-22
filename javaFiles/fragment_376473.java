@Test
public void callAuthenticate() {
    running(fakeApplication(), new Runnable() {
        public void run() {
            Map<String, String> formData = Maps.newHashMap();
            formData.put("email", "aaa@bbb.com");
            formData.put("password", "password");

            Result result = callAction(controllers.routes.ref.Users.authenticate(),
            fakeRequest().withFormUrlEncodedBody(formData));
            assertThat(status(result)).isEqualTo(Http.Status.OK);
        }
    }
}