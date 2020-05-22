(?:^|\s+|>)       # only start after at the string's beginning, after a row of
                  # spaces, or after closing a tag
                  # this eliminates all in-tag matches (like "li" and "br")
(                 # opening a capturing group that will contain the actual match
(?:[^<>.!?\s])    # require at least one character that is not in the given group
                  # this eliminates matching a single space between two <li>s
                  # NOTE: there are probably better ways to do this
(?:[^<>.!?]|\.\d) # defines possible sentence characters; allow everything but
                  # <, >, ., !, ? EXCEPT FOR . followed by a digit
(?:\.(?!\d)"?|!|\?)?
                  # include possible sentence endings; that is . not followed by
                  # a digit (hence, the negative lookahead), but possibly
                  # followed by ", or !, or ?, or nothing at all
)                 # close the main matching group