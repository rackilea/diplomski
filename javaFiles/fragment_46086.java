TextArea textArea = new TextArea(text);
textArea.setPrefColumnCount(40);
textArea.setPrefRowCount(20);
textArea.setEditable(false);
textArea.setWrapText(true);
alert.getDialogPane().setContent(textArea);