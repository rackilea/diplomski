String[] array = new String[size];
    char[] charArray = new char[length(word)];
    char[] temp = new char[length(word) / size];
    int place = 0;

    // turn the string into an array of chars
    for (int i = 0; i < charArray.length; i++) {
        charArray[i] = getChar(word, i);
    }

    // loop for each element of the desired string array
    for (int i = 0; i < array.length; i++) {

        // fill a temp array with the correct characters and the corect amount of characters
        for (int j = 0; j < charArray.length / size; j++) {                
            temp[j] = charArray[place];
            ++place;
        }

        // insert the temp array into each element of the string array
        array[i] = new String(temp);
    }

    return array;