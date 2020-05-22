(             # group and capture to \1:
  \b          #   the boundary between a word char (\w) and not a word char
  \w{5}       #   word characters (a-z, A-Z, 0-9, _) (5 times)
  \b          #   the boundary between a word char (\w) and not a word char
)             # end of \1
(?:           # group, but do not capture (4 times):
  .*?         #   any character except \n (0 or more times)
  \1          #   what was matched by capture \1
){4}          # end of grouping