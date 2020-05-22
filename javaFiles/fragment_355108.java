WordProcessor x = new WordProcessor();

while(scan.hasNext()) {
    initial = scan.next();
    x.addWord(initial);
}
scan.close();