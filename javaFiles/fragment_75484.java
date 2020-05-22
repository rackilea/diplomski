(       # Match and capture in backreference 1:
 (?:    #  Match this group:
  :0    #  :0
  \b    #  word boundary
 ){2,}  # twice or more
)       # End of capturing group 1
:?      # Match a : if present (not at the end of the address)
(?!     # Now assert that we can't match the following here:
 \S*    #  Any non-space character sequence
 \b     #  word boundary
 \1     #  the previous match
 :0     #  followed by another :0
 \b     #  word boundary
)       # End of lookahead. This ensures that there is not a longer
        # sequence of ":0"s in this address.
(\S*)   # Capture the rest of the address in backreference 2.
        # This is necessary to jump over any sequences of ":0"s
        # that are of the same length as the first one.