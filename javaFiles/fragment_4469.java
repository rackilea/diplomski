TextArea textArea = new TextArea();

// or, in Swing, JTextArea textArea = new JTextArea();

textArea.setText( System.getProperties().entrySet().stream()
    .map(e -> String.format("\"%s\" = %s", e.getKey(), e.getValue()))
    .collect(Collectors.joining("\n")));