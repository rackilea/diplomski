JTextArea msgArea = new JTextArea(10, 10);
msgArea.setWrapStyleWord(true);
msgArea.setLineWrap(true);      

JScrollPane msgScroller = new JScrollPane();        
msgScroller.setBorder(
    BorderFactory.createTitledBorder("Messages"));
msgScroller.setViewportView(msgArea);

panelObject.add(msgScroller);