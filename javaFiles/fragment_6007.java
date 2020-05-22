File copyOfFirstVar= tmp1;
File copyOfSecondVar= tmp2;

String firstPath = copyOfFirstVar.getAbsolutePath();
String secondPath = copyOfSecondVar.getAbsolutePath();

File tmpVar = File.createTempFile("temp", "tempFile");

tmp1.renameTo(tmpVar);
tmp2.renameTo(new File(firstPath));
tmp1.renameTo(new File(secondPath));