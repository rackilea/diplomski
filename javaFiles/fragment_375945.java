Document doc = editorPane.getDocument();

// remove the text you want to replace
doc.remove(startingOffset, length);

// add replacement
doc.insertString(startingOffset, newText, attributes);