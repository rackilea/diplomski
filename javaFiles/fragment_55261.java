PrintStream defaultOutStream = System.out;
PrintStream imprimir = new PrintStream(saida);
System.setOut(imprimir);
System.out.println(entrada);
saida.close();
System.setOut(defaultOutStream);