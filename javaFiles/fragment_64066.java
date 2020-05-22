class Recorder {
int xPos,yPos;
String eventType;
List<String> event = new ArrayList<String>();

int xevent = 0;
Recorder (int xPos, int yPos, String eventType ) {
    this.xPos = xPos;
    this.yPos = yPos ;
    this.eventType = eventType;
}

void recordEvent (String eventTime ) {
    event.add(eventTime);
    xevent++;
}
void printEvents(){
    System.out.println ("Record of " + eventType +
            " events at [" + xPos + "," + yPos + "] " );

    int index=0;
    for (String current: event) {
        String logOut=String.format("Event number %s was recorded at ",index);
        System.out.println(logOut+ current);
        index++;
    }
}