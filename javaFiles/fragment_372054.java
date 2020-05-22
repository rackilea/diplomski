^                 <-- Beginning of the line
    (.*?)         <-- Match anything (but ungreedy)
    \W*           <-- Match everything that's not a word/number (we'll ignore that)
    (\d{1,2})     <-- Match one or two digits (hours)
    :             <-- :
    (\d{1,2})     <-- Match one or two digits (minutes) [You should consider only matching two digits]
    \W*           <-- Match everything that's not a word/number (we'll ignore that)
    ([AaPp][Mm])? <-- Match AM or PM (and variants) if it exists
    .*            <-- Match everything else (we'll ignore that)
$                 <-- End of the line