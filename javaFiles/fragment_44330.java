Cookie cookie = Utils.fakeCookie("user@example.com");

Result result = callAction(
        controllers.routes.ref.yourSampleClass.yourSecuredFucntion(),
        fakeRequest().withFormUrlEncodedBody(
                ImmutableMap.of("Value", "Some input value")).withCookies(cookie));

// Should return redirect status if successful
assertThat(status(result)).isEqualTo(SEE_OTHER);
assertThat(redirectLocation(result)).isEqualTo("/yourWantedResult");