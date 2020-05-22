YourForm uploadForm = (YourForm) form;
FileOutputStream outputStream = null;
FormFile file = null;
try {
  file = uploadForm.getFile();
  String path = getServlet().getServletContext().getRealPath("")+"/"+file.getFileName();
  outputStream = new FileOutputStream(new File(path));
  outputStream.write(file.getFileData());
}
finally {
  if (outputStream != null) {
    outputStream.close();
  }
}