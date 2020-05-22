response.setContentType("image/gif");
String filepath = "PATH//TO//GIF.gif";
OutputStream out = response.getOutputStream();

InputStream in = new FileInputStream(new File(filepath));
try {
    FileUtils.copy(in, out);
finally {
    in.close();
}

out.close();