JTextField field = new JTextField(10);
((AbstractDocument)field.getDocument()).setDocumentFilter(new DocumentFilter(){
        Pattern regEx = Pattern.compile("\\d*");

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
            Matcher matcher = regEx.matcher(text);
            if(!matcher.matches()){
                return;
            }
            super.replace(fb, offset, length, text, attrs);
        }
    });