JTextPane pane = new JTextPane();
pane.setText("I've got to go\nI can stay, though.\nThree lines of text?");
System.out.println(pane.getText());

System.out.println("\n\n\n removing! \n\n\n");
Element root = pane.getDocument().getDefaultRootElement();
Element first = root.getElement(0);
pane.getDocument().remove(first.getStartOffset(), first.getEndOffset());
System.out.println(pane.getText());