Component[] components = examplePanel.getComponents();

for (Component singleComponent : components) {
   if (singleComponent instanceof JLabel) {
       JLabel label = (JLabel) singleComponent;

       if ("this is an example".equals(label.getText()) {
              label.setFont(new Font("", Font.PLAIN, 20));
       }
   }
}