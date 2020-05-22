(             # Match/capture in group 1:
 (?:          # Start of non-capturing group.
  (?!         # Assert that it's impossible to match...
   (?!\d*000) # (unless it's a number that contains 000)
   \d{3,6}    # a number of three to six digits here.
  )           # End of lookahead
  .           # Match any character
 )*           # End of non-capturing group, repeat any number of times
)             # End of capturing group 1