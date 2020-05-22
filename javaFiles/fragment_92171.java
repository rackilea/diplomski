InputStream is = mSocket.getInputStream();
DataInputStream dis = new DataInputStream(new GZIPInputStream(is));
int len = dis.readInt();
byte[] buff = new byte[len];
dis.readFully(buff);
String response = new String(buff, "UTF-8");
Data data = new Gson().fromJson(response, Data.class);