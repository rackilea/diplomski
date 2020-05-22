private WebView webView;
private WebEngine engine;

private void createCalendar() {
    webView = new WebView();
    engine = webView.getEngine();
    engine.load("file:D:/standAloneDev//src/fc/fullcalendarwebview/fullcalendar-1.6.4/demos/selectable.html");

    engine.getLoadWorker().stateProperty().addListener((ov,oldState, newState)->{
        if(newState==State.SUCCEEDED){

            // JS to Java
            JSObject script = (JSObject) engine.executeScript("window");
            script.setMember("myClick", new JavaApp());

            // Java to JS, function to create single event
            engine.executeScript("function addEvent(title, start, end) {\n" +
                            "var eventData = {\n" +
                            "   title: title,\n" +
                            "   start: start,\n" +
                            "   end: end\n" +
                            "};\n" +
                            "$('#calendar').fullCalendar('renderEvent', eventData, true);\n" +
                         "}");
        }
    });
}