switch (ch) // the next incoming character
{
    case '+':
    case '-':
    case '*':
    case '/':
    case '%':
    // etc.
        return ch;
    case 'A':
    case 'B':
    // ...
    case 'Z':
    case 'a':
    case 'b':
    // ...
    case 'z':
        // start of an identifier: accumulate it, with a do/while loop,
        // save it somewhere, return IDENTIFIER
        return IDENTIFIER;
    case '0':
    case '1':
    // ...
    case '9':
        // start of a numeric literal: ...
        return NUMERIC_LITERAL;
    // etc. 
}