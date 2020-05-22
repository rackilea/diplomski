public void mousePressed(MouseEvent me)
{
   pressed = me;
   Component component = me.getComponent();

   if (component instanceof JButton){
       JButton button = (JButton) component;
       uiBuilder.getTxtFieldsetText().setText(button.getText());
       uiBuilder.getTextFieldName().setText(button.getName());

       uiBuilder.getTxtFieldsetText().getDocument().addDocumentListener(new DocumentListener() {
           //...