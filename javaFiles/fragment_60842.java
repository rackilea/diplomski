@Override
public void start(Stage primaryStage) {
    Button btn=new Button("Add Events");
    btn.setOnAction(e->{

        // list of random events
        FullCalendarData data1=new FullCalendarData();
        data1.setEventName("Event 1");
        data1.setStartTime("2015-01-11T16:00:00");
        data1.setEndTime("2015-01-11T18:00:00");

        FullCalendarData data2=new FullCalendarData();
        data2.setEventName("Event 2");
        data2.setStartTime("2015-01-12T15:00:00");
        data2.setEndTime("2015-01-12T18:00:00");

        FullCalendarData data3=new FullCalendarData();
        data3.setEventName("Event 3");
        data3.setStartTime("2015-01-13T15:00:00");
        data3.setEndTime("2015-01-1316:00:00");

        CalendarEvents cal = new CalendarEvents();
        cal.addEvent(data1);
        cal.addEvent(data2);
        cal.addEvent(data3);

        Gson gson=new Gson();
        String json=gson.toJson(cal,CalendarEvents.class);

        engine.executeScript("addListEvents("+json+");");
    });

    createCalendar();

    Scene scene = new Scene(new VBox(webView,btn), 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}