[a-z]:(\\\\|/)|https?://

Options: Case insensitive; 

Match this alternative (attempting the next alternative only if this one fails) «[a-z]:(\\\\|/)»
   Match a single character in the range between “a” and “z” (case insensitive) «[a-z]»
   Match the character “:” literally «:»
   Match the regex below and capture its match into backreference number 1 «(\\\\|/)»
      Match this alternative (attempting the next alternative only if this one fails) «\\\\»
         Match the backslash character «\\»
         Match the backslash character «\\»
      Or match this alternative (the entire group fails if this one fails to match) «/»
         Match the character “/” literally «/»
Or match this alternative (the entire match attempt fails if this one fails to match) «https?://»
   Match the character string “http” literally (case insensitive) «http»
   Match the character “s” literally (case insensitive) «s?»
      Between zero and one times, as many times as possible, giving back as needed (greedy) «?»
   Match the character string “://” literally «://»


Insert the character “ ” literally « »