String file="\\webapps\\Ass2\\images\\"+FileName;
File f = new File(file);
f.getParentFile().mkdirs(); 
f.createNewFile();

FileOutputStream fos = new FileOutputStream(file);
fos.write(b);
imageInputStream.close();