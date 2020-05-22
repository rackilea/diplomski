static class MyDocumentListener2 implements DocumentListener {
      private boolean updating = false;

      public void insertUpdate(DocumentEvent e) {
         updateLog(e, "");
      }

      public void removeUpdate(DocumentEvent e) {
         updateLog(e, "");

      }

      public void changedUpdate(DocumentEvent e) {

      }

      public void updateLog(DocumentEvent e, String action) {
         if (updating) {
            return;
         }
         updating = true;

         final Document doc = (Document) e.getDocument();

         try {

            System.out.println("Action detected  " + doc.getProperty("type"));

            final String text = doc.getText(0, doc.getLength());

            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  try {
                     doc.insertString(0, "hey", null);
                     updating = false;
                  } catch (BadLocationException e) {
                     e.printStackTrace();
                  }
               }
            });

         } catch (BadLocationException catchme2) {
            catchme2.printStackTrace();
         }

      }
   }