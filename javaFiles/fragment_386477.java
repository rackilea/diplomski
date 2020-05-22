PrintWriter out;
File myfile = new File(folder,"output.txt");
myfile.createNewFile();
fos = new FileOutputStream(myfile);
out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos, "UTF-8")));
out.println("some text to go in the output file");