} else if (nextChar == '$') {
            // Skip past $
            cursor++;
            // The first number is always a group
            int refNum = (int)replacement.charAt(cursor) - '0';
            if ((refNum < 0)||(refNum > 9))
                throw new IllegalArgumentException(
                    "Illegal group reference");
            cursor++;

            // Capture the largest legal group string
            ...

            // Append group
            if (start(refNum) != -1 && end(refNum) != -1)
                result.append(text, start(refNum), end(refNum));
        } else {