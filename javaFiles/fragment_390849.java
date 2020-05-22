byte[] data = new byte[5120];
try {
   in = socket.getInputStream();
   int size = in.read(data);
   // see the received data from server in you LogCat
   Log.e("data from server", data.toString());
} catch (Exception e) {
   e.printStackTrace();
}