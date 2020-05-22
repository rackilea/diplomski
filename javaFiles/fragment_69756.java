} else {
        Boolean wordIsAllConsonants = true;
        for (int x = 0; x < word.length(); x++) {
            if(isVowel(word.charAt(x)) == true) {
                String partOfWord = word.substring(0,x);
                String secondPartOfWord = word.substring(x);
                String combination=secondPartOfWord + partOfWord;
                pigLatinWord = combination + "ay";
                wordIsAllConsonants = false;
                break;
            }
        }
        if(wordIsAllConsonants)
            pigLatinWord = word + "ay";
    }
    return pigLatinWord;