Object value = dataSnapshot.getValue();
if(value instanceof List) {
    List<Object> values = (List<Object>) value;
    // do your magic with values
}
else {
    // handle other possible types
}