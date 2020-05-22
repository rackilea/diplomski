@Override
public void start(Stage primaryStage) {

    Button btn=new Button("Add Event");
    btn.setOnAction(e->{
        FullCalendarData data1=new FullCalendarData();
        data1.setEventName("Event 1");
        data1.setStartTime("2015-01-11T16:00:00");
        data1.setEndTime("2015-01-11T18:00:00");
        engine.executeScript("addEvent('"+data1.getEventName()+
                             "','"+data1.getStartTime()+
                             "','"+data1.getEndTime()+"');");

    });

    createCalendar();

    Scene scene = new Scene(new VBox(webView,btn), 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}