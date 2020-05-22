case '$':
                    int i1 = i + 1;
                    while (i1 < replace.length () &&
                           Character.isDigit (replace.charAt (i1)))
                      i1++;
                    sb.append (m.substituteInto (replace.substring (i, i1)));
                    i = i1 - 1;
                    break;