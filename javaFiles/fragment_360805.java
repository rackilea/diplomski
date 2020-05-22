for(i=0;i<str.length();i++){//for loop starts here
         ext=str.charAt(i);//extracting character present at ith index of str
         if(ext!=' '){
             temp=temp+ext;//storing characters other than whitespace
            }
            else{//this condition works when character extracted from str is not whitespace
                for(i=temp.length()-1;i>=0;i--){//loop for reversing each word
                    rev=rev+temp.charAt(i);//reversing the word pesent in temp
                }

        temp="";//reinitialising variable temp
        sen=sen+rev+" ";//new string gets concatenated with each word and a space
        rev="";//reinitialising variable rev
    }