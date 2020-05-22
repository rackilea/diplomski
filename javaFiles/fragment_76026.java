^                        the beginning of the string
  (                        group and capture to \1:
    .                        any character except \n
  )                        end of \1
  \1{1,}                   what was matched by capture \1 (at least 1 times)
  $                        the end of the string