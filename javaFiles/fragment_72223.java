@Test
    public void
    the_output_does_not_get_populated_when_the_request_is_empty
    () {
        Mockery context = new Mockery();
        final ParameterSource mockSource = context.mock(ParameterSource.class)

context.checking(new Expectations(){{
    oneOf(mockSource).getParameters(); 
            will(returnValue(new string[]{"ParamA","ParamB","ParamC"} );
}});
        aBitOfLegacy.populate(mockSource);
        assertThat(aBitOfLegacy.output,not(EMPTY));
    }