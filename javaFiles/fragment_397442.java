if ((c == 'A') || (c == 'a') || (c == 'E') || (c == 'e') || (c == 'I') || (c == 'i')
             || (c == 'O') || (c == 'o') || (c == 'U') || (c == 'u')) {
                String front = word.substring(0, i);
                String back = word.substring(i + 1);
                String NewWord = front + "" + back; 
                return NewWord;

        }
            /*HERE is where you needed the return value*/
       else
            return somethingElse;
        }