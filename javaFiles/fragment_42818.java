else if (ch == '\''){
     token.append( '\'' );
     pos++;
     while( pos < input.length() &&
            (ch = input.charAt(pos++)) != '\'' ){
         token.append( ch );
     }
     token.append( '\'' );