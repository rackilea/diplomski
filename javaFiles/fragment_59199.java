(?:                      # Opens NCG1
     (                    # Opens CG1
         [\s\S]*?         # Character class (any of the characters within)
                            # A character class and negated character class, common expression meaning any character.
                            # * repeats zero or more times
                            # ? as few times as possible
     )                    # Closes CG1
     (?:                  # Opens NCG2
         (                # Opens CG2
             \n           # Token: \n (newline)
             \n           # Token: \n (newline)
         )                # Closes CG2
         \n               # Token: \n (newline)
         \n               # Token: \n (newline)
     )?                   # Closes NCG2
                            # ? repeats zero or one times
 )                        # Closes NCG1
 # begin repeat section
 (?:                      # Opens NCG3
     (                    # Opens CG3
         [\s\S]*?         # Character class (any of the characters within)
                            # A character class and negated character class, common expression meaning any character.
     )                    # Closes CG3
     (                    # Opens CG4
         \n               # Token: \n (newline)
         \n               # Token: \n (newline)
     )                    # Closes CG4
     \n                   # Token: \n (newline)
     \n                   # Token: \n (newline)
 )?                       # Closes NCG3
 # end repeat section
 (                        # Opens CG5
     [\s\S]*?             # Character class (any of the characters within)
 )                        # Closes CG5
 ={5,}                    # Literal =
                            # Repeats 5 or more times
 [\s\S]*                  # Character class (any of the characters within)
                            # * repeats zero or more times