FileOutputStream output = new FileOutputStream("filename", true);
try {
   output.write(data);
} finally {
   output.close();
}