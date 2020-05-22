while(scan.hasNext()) {
    initial = scan.next();
    // You do **nothing** with the String read in
}

scan.close();

System.out.println("Scanning Paragraph.....\n");
WordProcessor x = new WordProcessor();
x.addWord(initial);  // until here where you add the last one