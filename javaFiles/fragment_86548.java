final private static String EVENT_NAME = "whateverEventNameYouWant";

@Inject
private ComponentResources resources;

@Inject
private JavaScriptSupport javaScriptSupport;

/** Method that will provide the value you want to pass to JS. */
@OnEvent(EVENT_NAME) 
public JSONObject provideValue() {
    JSONObject object = new JSONObject();
    object.put("value", /* the value you want to pass to JS */);
    // other values you may want to pass
    return object;
}

void afterRender() {
    // This creates an URL for the event you created. Requesting it will
    // invoke any event handler methods for that event name.
    Link link = resources.createEventLink(EVENT_NAME);
    javaScriptSupport.addScript("var eventUrl = '%s';", link.); // the JavaScript variable name doesn't matter. You can choose any you want
}