br = new BufferedReader(new FileReader("BookList.txt"));
String line;
while ((line = br.readLine()) != null) {
    listmodel.addElement(line);
}
booklist.setModel(listmodel);