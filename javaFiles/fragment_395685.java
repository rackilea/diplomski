public List<Char> letterTested;
    private void tryALetter(Char oneLetter){
          for ( int i = 0; i < answer.length(); i++){
                     if (oneLetter == answer.charAt(i){
                           letterTested.add(oneLetter); 
                     }
          }
    }    

    private void printWordStatus() 
        {
            for ( int i = 0; i < answer.length(); i++)
            {
                String answer = this.answer;
                String word = "";
                char c = answer.charAt(i);

                if (c == ' ')
                {
                    word += c;
                }else 
                { /* here you test if the letter is in the list 
                   if it is in the list, you print the letter, not the "_" */
                  for(int j = 0; j < letterTested.lenght(); j++){
                       if (c == letterTested.get(j)){
                                word += c;
                    } else {
                       word += " _ ";
                    }
                  }
                }
                System.out.print(word);
            }

        }