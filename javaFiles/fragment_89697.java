private static class NewDocument implements ActionListener
   {
      private ModelDocumentHolder model;

      public NewDocument( ModelDocumentHolder model )
      {
         this.model = model;
      }

      @Override
      public void actionPerformed( ActionEvent e )
      {
         model.setDoc( new Document() );
      }
   }