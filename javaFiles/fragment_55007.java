@Test(enabled = true)
    public void does_URI_or_URL_mangle_single_slash_paths_example_4()
        throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
        // ARRANGE
        String sut = "http://localhost:8800/api/exchanges/%2F?";

        // ACT
        URI uri = new URI(sut);
        String result = uri.toURL().toString();

        // ASSERT
        assertThat(uri.getPath()).isEqualTo("/api/exchanges//"); // <== this seems wrong!
        assertThat(uri.toString()).isEqualTo("http://localhost:8800/api/exchanges/%2F?");
        assertThat(uri.toASCIIString()).isEqualTo("http://localhost:8800/api/exchanges/%2F?");
    }