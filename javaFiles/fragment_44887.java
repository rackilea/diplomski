DefaultListModel<String> lines = new DefaultListModel<String>();
JList l = new JList(lines);
JScrollPane scrp =  new JScrollPane(l);

while(reader.hasNextLine()) {
    lines.addElement(reader.nextLine());
}