int userSpecialkey = 123;    

File f = new File("FileName.txt");

f.createNewFile();

BufferedWriter bw = new BufferedWriter(new FileWriter(f));

bw.write(userSpecialkey);

bw.close();