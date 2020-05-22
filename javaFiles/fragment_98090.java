"(?=" +         // Assert that the regex below can be matched, starting at this position (positive lookahead)
   "." +           // Match any single character
      "*" +           // Between zero and unlimited times, as many times as possible, giving back as needed (greedy)
   "\\d" +          // Match a single digit 0..9
")" +
"(?=" +         // Assert that the regex below can be matched, starting at this position (positive lookahead)
   "." +           // Match any single character
      "*" +           // Between zero and unlimited times, as many times as possible, giving back as needed (greedy)
"[a-zA-Z]" +       // Match a single character present in the list below
                     // A character in the range between “a” and “z”
                     // A character in the range between “A” and “Z”
")" +
"\\w" +          // Match a single character that is a “word character” (letters, digits, and underscores)
   "{7,}"          // Between 7 and unlimited times, as many times as possible, giving back as needed (greedy)