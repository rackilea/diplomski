//scanner.useDelimiter("Event=|,time=([0-9]*)");
scanner.useDelimiter("Event=|,(.)+[\\r\\n]*Event=|,(.)+[\\r\\n]*");

//for better you can use this

//scanner.useDelimiter("Event=|,time=([0-9]**)[\\r\\n]**Event=|,time=([0-9]*)");

while (scanner.hasNext()) 
{
    System.out.println(scanner.next());
}