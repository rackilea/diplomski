@Test
public void shouldAdditionalContextParamsBeAvailable() throws Exception {
    // given
    String key = "application";
    assertNull(ActionContext.getContext().get(key));

    // when
    String output = executeAction("/home");

    // then
    assertNotNull(ActionContext.getContext().get(key));
}

@Override
protected void applyAdditionalParams(ActionContext context) {
    Map<String, Object> application = new HashMap<String, Object>();
    application.put("options","home");
    context.put("application", application);
}