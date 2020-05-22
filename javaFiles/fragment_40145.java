StringWriter buffer = new StringWriter();
PrintWriter writer = new PrintWriter(buffer);
foo.print(writer);

String contents = buffer.toString();
myTextArea.setText(contents);