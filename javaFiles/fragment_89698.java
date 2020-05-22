private static class RegularListener implements ActionListener
   {
      private ModelDocumentHolder model;

      public RegularListener( ModelDocumentHolder model )
      {
         this.model = model;
      }

      @Override
      public void actionPerformed( ActionEvent e )
      {
         JComponent source = (JComponent) e.getSource();
         Document doc = model.getDoc();
         // do stuff...
      }
   }