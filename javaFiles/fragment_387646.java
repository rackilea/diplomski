private String[] removeFirstSet(String input)
    //removes the first set of adjecent letters from a string, and returns it.
    {
        String[] words = new String[2];
        int index = 0;
        if(input.length()<1) words[0] = "";
        while(index<input.length()){
            //this loop to retrieve the first word.
            if( isLetter(input.charAt(index))||isNumber(input.charAt(index))){
                index++; //if the first char is a letter, move on to the next one.
            }
            else{ 
                words[0]=input.substring(0,index);
                words[1]=input.substring(index);
                return words;
            }
        }
        if(index==input.length()){
             words[0]=input.substring(0,index);
             words[1]=input.substring(index);
             return words;
        }
        return new String[]{"",""};
    }