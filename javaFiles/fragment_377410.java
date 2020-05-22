for( String s : values ) {
     computeSomething( s );
      ... a dozen of lines here... 
     s = s.trim();// or worst s = getOtherString();
     ... another dozen of line 
     otherComputation( s );
 }