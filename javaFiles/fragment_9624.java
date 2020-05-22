(?m)                    # enable multilie mode
^ {4}\\S.*$             # match a line with exact 4 spaces at start
\\r?\\n                 # followed by a line feed character
(?:^ {4}\\S.*$\\r?\\n)* # match 0 or more of such lines
^ {4}\\S.*$             # followed by a line with exact 4 spaces at start
<pre>\\n$1\\n</pre>     # replace by <pre> newline matched block newline </pre>