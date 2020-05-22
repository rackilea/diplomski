(?x)

# lookbehind to check for start of string or previous param
# java lookbehinds must have max length, so limits sqltype
(?<=^|sqltype='cf_sql_[a-z]{1,16}']\ ,\ )

# capture the full string for replacing in the orig sql
# and just the position to verify against the match position
(\(param\ (\d+)\))

\ =\ \[

# type and class wont contain quotes
   type='([^']++)'
,\ class='([^']++)'

# match any non-quote, then lazily keep going
,\ value='([^']++.*?)'

# sqltype is always alphanumeric
,\ sqltype='cf_sql_[a-z]+'

\]

# lookahead to check for end of string or next param
(?=$|\ ,\ \(param\ \d+\)\ =\ \[)