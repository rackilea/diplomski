int width = textArea.getSize().width;
int height = textArea.modelToView(0).height / 2;
int offset = textArea.viewToModel( new Point(width, height) );
int start = Utilities.getPreviousWord( offset );  // or maybe getWordStart(...)?
int end = Utilitities.getWordEnd( start );
String text = textArea.getText(start, end - start);