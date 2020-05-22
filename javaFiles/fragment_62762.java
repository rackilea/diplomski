PrintWriter out = new PrintWriter(
   new BufferedWriter(
       new OutputStreamWriter(
           new FileOutputStream("SUB/myfile.txt"),"UTF-8")));
out.println("simpleString);
out.close();