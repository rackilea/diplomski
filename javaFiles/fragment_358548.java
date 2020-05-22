Document doc = new PlainDocument();
    SimpleAttributeSet set = new SimpleAttributeSet();
    try {
        doc.insertString(0, "your content", set);
    } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    textArea.setDocument(doc);