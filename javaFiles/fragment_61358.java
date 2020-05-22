Map<String, JTextField> fieldMap = new HashMap<String, JTextField>();
String[] labels = {"Non-animated image name:","Left animation image name:","Top animation image name:",
        "Right animation image name:","Bottom animation image name:"};
for(int i=0; i<labels.length; i++){
    JLabel l = new JLabel(labels[i],JLabel.TRAILING);
    JTextField n = new JTextField(10);
    panel3.add(l);
    l.setLabelFor(n);
    panel3.add(n);
    fieldMap.put(labels[i], n);
}

// and then later you can get the text field associated with the String:
String text = fieldMap.get(labels[2]).getText();