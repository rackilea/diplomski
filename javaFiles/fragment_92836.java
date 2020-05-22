protected boolean touchEvent( TouchEvent message )    {
      int x = message.getX( 1 );        
      int y = message.getY( 1 );        
      if( x < 0 || y < 0 || x > getExtent().width || y > getExtent().height ) {
         // Outside the field            
         return false;       
      }        

      switch( message.getEvent() ) {                  
      case TouchEvent.UNCLICK:                
         fieldChangeNotify(0);               
         return true;        
      }        
      return super.touchEvent( message );    
   }

   protected boolean navigationClick(int status, int time) {
      if (status != 0) {        // you did not have this check
         fieldChangeNotify(0);
      }
      return true;
   }