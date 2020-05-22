for( int i = 0; i < numRows; i++ )
{
  //print whitespace for correct indentation
  for( int j = 0; j < numRows - i; j++ )
  {
    System.out.print( " " );
  }

  //print the first asterisk
  System.out.print( "*" );

  //print as many A* as needed, i.e. row-1 times 
  for( int k = 0; k < i; k++ )
  {
    System.out.print( "A*" );        
  }
  System.out.println();
}