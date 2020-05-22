JPanel textPanel = new JPanel();
textPanel.setLayout(new BorderLayout());
textPanel.setName("Text Panel");

// **** note change:
textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);