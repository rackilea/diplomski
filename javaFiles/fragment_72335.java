(\b\S{7,}\b)/

1st Capturing group (\b\S{7,}\b)
    \b assert position at a word boundary (^\w|\w$|\W\w|\w\W)
    \S{7,} match any non-white space character [^\r\n\t\f ]
        Quantifier: {7,} Between 7 and unlimited times, as many times as possible, giving back as needed [greedy]
    \b assert position at a word boundary (^\w|\w$|\W\w|\w\W)