FileInputStream fis = new FileInputStream(pFile);
FileOutputStream fos = new FileOutputStream(targetFile);
copyStream(fis, fos, 10000);
fos.flush();
fos.close();
fis.close();