SensorLocation sl = new SensorLocation (10.1235, -36.1346, 10.124);
Parcelable outgoingParcelable = Parceler.wrap(sl);
//Add to intent, etc.

//Read back in from incoming intent
Parcelable incomingParcelable = ...
SensorLocation sl = Parceler.unwrap(incomingParcelable);
Serializer s = new Persister();
ByteArrayOutputStream out = new ByteArrayOutputStream();
s.write(sl, out);