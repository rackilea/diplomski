String output = String.format("Hello%sthere!",System.getProperty("line.separator"));
BufferedWriter oFile = new BufferedWriter(new OutputStreamWriter(
    new FileOutputStream("test.txt"), "UTF-16"));

System.out.println(output);
oFile.write(output);
oFile.close();