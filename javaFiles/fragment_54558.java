\d{3}                    digits (0-9) (3 times)
  (                        group and capture to \1:
    [-.]                     any character of: '-', '.'
  )                        end of \1
  \d{3}                    digits (0-9) (3 times)
  \1                       what was matched by capture \1
  \d{4}                    digits (0-9) (4 times)