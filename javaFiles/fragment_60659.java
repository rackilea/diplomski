// Make a new frame, and point it at Google.
Frame frame = new Frame("http://www.google.com/");

DivElement div = Document.get().createDivElement();
div.setAttribute("align", "center");

div.appendChild(frame.getElement());

// Add it to the root panel.
RootPanel.get().getElement().appendChild(div);