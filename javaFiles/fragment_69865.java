<!--

    (?is)\{[^}]*?\}(?=.*?\})

    Match the remainder of the regex with the options: case insensitive (i); dot matches newline (s) «(?is)»
    Match the character “{” literally «\{»
    Match any character that is NOT a “}” «[^}]*?»
       Between zero and unlimited times, as few times as possible, expanding as needed (lazy) «*?»
    Match the character “}” literally «\}»
    Assert that the regex below can be matched, starting at this position (positive lookahead) «(?=.*?\})»
       Match any single character «.*?»
          Between zero and unlimited times, as few times as possible, expanding as needed (lazy) «*?»
       Match the character “}” literally «\}»
    -->