try {
        input = new BufferedReader(new FileReader("file.txt"));
        strLine = input.readLine();
        while(strLine!= null){

            String[] tokens = strLine.split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                if(strLine.isEmpty()){
                    continue;
                }
                String s = tokens[i];
                wordsJoin += tokens[i] + " ";

                wordCount += i;
                int len = s.length();
                String charString = s.replaceAll("[^a-zA-Z ]", "");
                for(int k =0; k<charString.length(); k++){
                    currentChar = charString.charAt(k);
                    if(Character.isLetter(currentChar)){ 
                        lettersCount++;
                    }  
                }
                if (s.charAt(len - 1) == '.' || s.charAt(len - 1) == '?' || s.charAt(len - 1) == '!') {
                    sentences.add(new Sentence(wordsJoin, wordCount));
                    sentCount++;
                    numOfWords += countWords(wordsJoin);
                    wordsJoin = "";
                    wordCount = 0;
                } 
            }
            strLine = input.readLine();
        }