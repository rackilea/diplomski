(?i)(\\bSET\\b|\\bUNSET\\b)(.*?\\btime\\b.*?)?(\d{2}\\:\\d{2}(\\s+)?(am|pm)?)

(?i)
match the remainder of the pattern with the following effective flags: gmi
i modifier: insensitive. Case insensitive match (ignores case of [a-zA-Z])

1st Capturing Group:   (\\bSET\\b|\\bUNSET\\b)
1st Alternative:  \\bSET\\b
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)
SET matches the characters SET literally (case insensitive)
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)

2nd Alternative:  \\bUNSET\\b
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)
UNSET matches the characters UNSET literally (case insensitive)
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)

2nd Capturing Group:   (.*?\\btime\\b.*?)?
? Quantifier — Matches between zero and one times, as many times as possible, giving back as needed (greedy)
.*?  matches any character (except for line terminators)
*? Quantifier — Matches between zero and unlimited times, as few times as possible, expanding as needed (lazy)
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)
time matches the characters time literally (case insensitive)
\\b assert position at a word boundary: (^\w|\w$|\W\w|\w\W)
.*?  matches any character (except for line terminators)

3rd Capturing Group:  (\\d{2}\\:\\d{2}(\\s+)?(am|pm)?)
\\d{2}  matches a digit (equal to [0-9])
{2} Quantifier — Matches exactly 2 times 
\\: matches the character : literally (case insensitive)
\\d{2}  matches a digit (equal to [0-9])
{2} Quantifier — Matches exactly 2 times 

4th Capturing Group:   (\\s+)?
? Quantifier — Matches between zero and one times, as many times as possible, giving back as needed (greedy)
\s+  matches any whitespace character (equal to [\r\n\t\f\v ])

5th Capturing Group:   (am|pm)?
? Quantifier — Matches between zero and one times, as many times as possible, giving back as needed (greedy)
1st Alternative:   am
am matches the characters am literally (case insensitive)
2nd Alternative:  pm
pm matches the characters pm literally (case insensitive)