FlightRecording flightRecording = FlightRecordingLoader.loadFile(new File(...));
IView recording = flightRecording.createView();
for (IEvent event : recording) {
    FLRMethod method = (FLRMethod) event.getValue("((stackTrace).method)");
    /* this shows the bytes read by method at some invocation(if any), 
    so for total bytes read by method you will need to sum manually */
    long bytesRead = Long.valueOf(String.valueOf(event.getValue("bytesRead")));
}