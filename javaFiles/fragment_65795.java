Button[] buttons = new Button[]{ button1, button2, ... button15,  button16 }; 
// fill in the other buttons above

Random generator = new Random();
number = generator.nextInt(16); 

for( int i=0; i<buttons.length; i++ ) {
   if( i == number )
       buttons[i].setVisibility( View.VISIBLE );
   else
       buttons[i].setVisibility( View.INVISIBLE );
}