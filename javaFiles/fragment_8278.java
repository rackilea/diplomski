JTextArea left = new JTextArea(10, 20);
    JTextArea right = new JTextArea(10, 20);

    MirrorDocument leftDoc = new MirrorDocument();
    MirrorDocument rightDoc = new MirrorDocument();

    left.setDocument(leftDoc);
    right.setDocument(rightDoc);

    leftDoc.addDocumentListener(new DocumentHandler(rightDoc));
    rightDoc.addDocumentListener(new DocumentHandler(leftDoc));