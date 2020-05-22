final HTMLEditorKit htmlKit = new HTMLEditorKit();
    final JTextPane textPane = new JTextPane( );
    textPane.setEditorKit(htmlKit);
    textPane.setEditable(true);
    JScrollPane scrollPane = new JScrollPane( textPane );

    Document doc = textPane.getDocument();
    System.out.println(doc.getClass().getName()); // It's an HTML Document