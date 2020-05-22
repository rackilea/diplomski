for (int i = 0; i < chars.length; i++) {
     char c = chars[i];
     Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
     if(block != Character.UnicodeBlock.HIGH_SURROGATES && 
        block != Character.UnicodeBlock.LOW_SURROGATES) {
           strb.append(c);
     }
 }