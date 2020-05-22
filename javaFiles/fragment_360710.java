# (?i)\d(?=\d{0,3}[a-z])[a-z\d]{3,4}\d

 (?i)
 \d                   # A digit
 (?= \d{0,3} [a-z] )  # a letter in the next 1 to 4 characters
 [a-z\d]{3,4}         # 3 to 4 digits or letters
 \d                   # A digit