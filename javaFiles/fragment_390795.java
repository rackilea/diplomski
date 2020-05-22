public void writeExternal(ObjectOutput out) throws IOException {

out.writeUTF(name);
out.writeInt(age);
out.writeDouble(weight);
 out.flush();
 out.close(); <-----