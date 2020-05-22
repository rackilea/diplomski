reader = urlConnection.getInputStream();
int bRead = -1;
byte[] buffer = new byte[1024];
do {
  bRead = reader.read(buffer, 0, 1024);
  if (bRead == -1) {
    break;
  }
  data += new String(buffer, 0, bRead);
} while (true);