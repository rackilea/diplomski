public boolean contains (char character){
        for(int i = 0; i < letters.length(); i++) {
            if(letters.charAt(i) == character)
                return true;
        }
        return false;
    }