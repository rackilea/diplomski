/^(.+) = https:\/\/(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})$/m
^ Start of line
1st Capturing group (.+) 
. 1 to infinite times [greedy] Any character (except newline)
 = https:\/\/ Literal  = https://
2nd Capturing group (\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}) 
\d 1 to 3 times [greedy] Digit [0-9]
\. Literal .
\d 1 to 3 times [greedy] Digit [0-9]
\. Literal .
\d 1 to 3 times [greedy] Digit [0-9]
\. Literal .
\d 1 to 3 times [greedy] Digit [0-9]
$ End of line
m modifier: multi-line. Causes ^ and $ to match the begin/end of each line (not only begin/end of string)