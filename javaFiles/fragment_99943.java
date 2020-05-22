static boolean isLower(char character){

    if(character>='a'&&character<='z'){//if lowercase
        return true;
    } else {//if uppercase or any other character different than a letter
        return false;
    }
}