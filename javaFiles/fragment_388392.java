private void iterateOverContent(JTextPane tp2) {
        for(int i = 0; i < tp.getDocument().getLength(); i++) {
            Element elem = ((StyledDocument) tp.getDocument()).getCharacterElement(i);
            AttributeSet as = elem.getAttributes();
            if (as.containsAttribute(AbstractDocument.ElementNameAttribute, StyleConstants.ComponentElementName)) {
                if(StyleConstants.getComponent(as) instanceof JLabel) {
                    JLabel myLabel = (JLabel)StyleConstants.getComponent(as);
                    System.out.println(myLabel.getText());
                }
            }
            System.out.println(((StyledDocument) tp.getDocument()).getCharacterElement(i));
        }
}