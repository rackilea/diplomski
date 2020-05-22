for(int i = 0 ; i < word.length() ; i++)
            {
                for(int j = 0 ; j < alphabet.length ; j++)
                {
                    // show indices
                    System.out.println("i = " + i + " j = " + j);           
                    word2 = word.substring(0,i) + alphabet[j] + word.substring(i+1); ;
                            if (!word2.equals(word) {
                            System.out.println(word2);
                            }
                }

            }