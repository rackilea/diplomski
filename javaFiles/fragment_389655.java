//boolean here is for append
Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("path\\log.txt", true), "UTF-8"))
 //boolean here is for autoflush
 PrintWriter logput = new PrintWriter(writer,  true);
for (String symb : symbolList) {
   System.out.println(symb);
   logput.println(symb);
 }
 logput.close();