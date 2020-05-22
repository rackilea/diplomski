JPanel  myPanel = new JPanel();
  new  FileDrop( myPanel, new FileDrop.Listener()
  {   public void  filesDropped( java.io.File[] files )
      {   
          // handle file drop
          ...
      }   // end filesDropped
  }); // end FileDrop.Listener