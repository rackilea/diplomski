^                     # Start of string
(?:                   # Start of group
[1-9][0-9]{7}         # Match digit > 0, followed by 7 digits
|                     # or
[0-9][1-9][0-9]{6}    # Match any digit, a digit 1-9, 6 other digits
|                     # or
[0-9]{2}[1-9][0-9]{5} # Match 2 digits, a digit 1-9, 5 other digits
|                     # or
...                   # etc. etc. etc.
)                     # End of group
$                     # End of string