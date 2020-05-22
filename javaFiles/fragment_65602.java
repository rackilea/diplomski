Pattern patt = Pattern.compile("(?x)      "   // Embedded flag for Pattern.COMMENT
                             + "\\[       "   // Match starting `[`
                             + "    [jc]  "     // Match j or c
                             + "    -     "     // then a hyphen
                             + "    [^    "     // A negated character class
                             + "       \\]"        // Match any character except ] 
                             + "    ]*    "     // 0 or more times
                             + "\\]       "); // till the closing ]