^
(?=[abcd]*e)     # make sure there is an "e"
(?:
  ([abcde])      # match a character and capture it
  (?!            # make sure it's not repeated
    [abcde]*?
    \1           # reference to the previously matched char
  )
){2,5}
$