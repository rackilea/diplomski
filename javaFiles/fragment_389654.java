PrintWriter logput = new PrintWriter(new FileOutputStream("path\\log.txt", true),  true);
for (String symb : symbolList) {
   System.out.println(symb);
   logput.println(symb);
 }
 logput.close();