public static void main( String[] args )
   {
      ModelDocumentHolder model = new ModelDocumentHolder();
      View view = new View();
      ActionListener listener = new NewDocument( model );
      view.addActionListener( listener );
      View view2 = new View();
      view2.addActionListener( new RegularListener( model ) );
   }