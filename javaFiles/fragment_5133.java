Font font = new Font(fontName, fontStyle, fontSize);
//Panel mainPanel = new Panel();
Panel textPlacePanel = new Panel(new BorderLayout());
Panel buttonPlacePanel = new Panel(new GridLayout(1, 3));
Button increaseButton = new Button("Increase");

Button decreaseButton = new Button("Decrease");
Label label = new Label("Font size");
TextArea textArea = new TextArea();
textArea.setFont(font);

//frame.add(mainPanel, BorderLayout.CENTER);
frame.add(buttonPlacePanel, BorderLayout.SOUTH);
frame.add(textPlacePanel, BorderLayout.CENTER);