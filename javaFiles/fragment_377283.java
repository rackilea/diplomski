^ \s*              # Line starts with one or more spaces
  \w+              # a word (1 or more letters, numbers and '_')
  (?:\s+\w+)*?     # several extra words, separated by spaces. Ungreedy
  (?:\s*<\w+>)?    # Optional '<' + Word '>'
  \s+(\w+)         # Capture the variable with a group ()
  (?=\s*[=;])      # It must be followed by spaces and then '=' or ';'