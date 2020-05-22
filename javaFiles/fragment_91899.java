List<Subscriber> subscribers = new ArrayList<Subscriber>();
String newSub;
// set newSub from user input via Scanner

Subscriber myNewSub = new Subscriber(newSub, "new message");
if (!subscribers.contains(myNewSub)){
    subscribers.add(myNewSub);
}