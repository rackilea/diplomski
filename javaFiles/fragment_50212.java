String[] nowTyping = "It is broken!".split(" ");
            ArrayList<String> wordArray = new ArrayList<>();
            ArrayList<String> symbolsArray = new ArrayList<>();
            int cnt=0;
            for (int j=nowTyping.length-1 ;j >=0;j--) {
                String word = nowTyping[j];
                if (word.length()>0) {
                    word = word.toLowerCase();
                    char firstChar = word.charAt(0);
                    if (cnt == 0) {
                        boolean isFirstCharFounded = false;
                        for (int i = 0; i < word.length(); i++) {
                            if (!isFirstCharFounded&&Character.isAlphabetic(word.charAt(i))) {
                                firstChar = word.charAt(i);
                                isFirstCharFounded = true;
                            } else if (!(Character.isDigit(word.charAt(i))||Character.isAlphabetic(word.charAt(i)))) {
                                symbolsArray.add(word.charAt(i) + "");
                                word = word.replace(word.charAt(i)+"","");
                            }
                        }

                        firstChar = Character.toUpperCase(firstChar);
                        cnt++;
                    }
                    if (word.length()>=2) {
                        word = firstChar + word.substring(1);
                    }
                    else {
                        word = firstChar + "";
                    }

                    wordArray.add( word);
                }
            }
            String invertedSentence = TextUtils.join(" ", wordArray);
            invertedSentence += TextUtils.join("",symbolsArray);