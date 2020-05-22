@Override
public void readExternal(ObjectInput in) throws IOException,
  ClassNotFoundException {
  this.setId((String) in.readObject());
  Object nameField = in.readObject();
  if (nameField != null) {
    boolean resolved = false;
    if (nameField instanceof String) {
      ArrayList<String> list = new ArrayList<String>(); // Or whatever you want to for converting the String to list.
      list.add((String)nameField);
      this.setName(list);
      resolved = true;
    }
    if (nameField instanceof List) {
      this.setName((List<String>) nameField);
      resolved = true;
    }
    if (!resolved) {
      throw new Exception("Could not deserialize " + nameField + " into name attribute");
    }
  }
}