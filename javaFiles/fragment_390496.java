Put all your keywords in a HashSet (Set<String> keywords;)
Read the file one line at once
  For each line in file:
  Tokenize to words
  For each word in line:
  If word is contained in keywords (keywords.containes(word))
    Process actual line
    If previous line is available
        Process previous line
  Keep track of previous line (prevLine = line;)