Map<SeptTuple, SeptTuple> map = new HashMap<>();
....
// If already set, map will return the old value on put
SeptTuple temp = map.put(newSetTuple, newSetTuple);
if(temp != null) {
   // handle clash
}