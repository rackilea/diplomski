// matches the whole line:
//            ┌ start of input
//            | ┌ any or no whitespace (as your original pattern suggests)
//            | |  ┌ literal "name"
//            | |  |   ┌ any other character sequence to follow, or no characters
line.matches("^\\s*name.*");