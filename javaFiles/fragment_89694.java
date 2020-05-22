public static void main( String[] args )
   {
      Model model = new Model();
      View view = new View();
      ActionListener listener = new MyActionListener( model, view );
      view.addActionListener( listener );
   }

   private static class MyActionListener implements ActionListener
   {
      private Model model;
      private View view;

      public MyActionListener( Model model, View view )
      {
         this.model = model;
         this.view = view;
      }
   }