ByteArrayOutputStream buf = ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(buf);
oos.writeObject(x);
oos.flush();
oos.close();
/* BAD! you should specify encoding! */
String encoded = new String(buf.toByteArray());