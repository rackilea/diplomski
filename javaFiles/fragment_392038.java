AlertSystemDaemon alertsystemdaemonobject = new AlertSystemDaemon();
String someNameYouWant = null;
try {
    someNameYouWant = alertsystemdaemonobject.alertSystemMessage();
} catch (IOException e1) {
    e1.printStackTrace();
}
//use someNameYouWant at your will.