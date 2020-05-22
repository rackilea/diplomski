String filename = "myfile.txt";

Vector v = new Vector(10.0f, 20.0f);
Gson gson = new Gson();
String s = gson.toJson(v);

FileOutputStream outputStream;

try {
  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
  outputStream.write(s.getBytes());
  outputStream.close();
} catch (Exception e) {
  e.printStackTrace();
}