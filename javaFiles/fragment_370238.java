String line = <input string>
List<String>fields = new ArrayList<String>();
StringBuffer field = new StringBuffer();
for( int i = 0 ; i < line.length(); i++){
   char c = line.charAt(i);
   switch( state ){
      NO_QUOTE:
         // check if character is a quote or a comma.  If neither append character to field
         if( quote )  
            // change state
            state = IN_QUOTES;
         else if( comman )
            // close the field and start a new one
            fields.add(field.toString());
            field = new StringBuffer();
         else
            field.append(c);
         break;

      IN_QUOTES:
         // only search for a closed quote mark
         if( quote )  
            // change state
            state = OUT_QUOTES;
         else
            field.append(c);
   }