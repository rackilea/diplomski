int count = 0;
  System.out.println( "Are you bored yet? 1 for yes; 0 for no." );
    value = input.nextInt();

  while ( value != 1 && count < 10)    

  {
    count = count + 1;
    System.out.print("Are you bored yet? 1 for yes, 0 for no."); value = input.nextInt(); 

  }

  System.out.println( "Finally!");
}