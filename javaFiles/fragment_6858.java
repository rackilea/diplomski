File file = new File("the same path");
file.createNewFile();
Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file, true), "UTF-8"));
out.write(fileContent);
out.flush();
out.close();