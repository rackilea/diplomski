rule "checkHM"
when
  $account : Account( hm[ "A" ] == "B" )
then
  System.out.println( "HashMap has value B" );
end