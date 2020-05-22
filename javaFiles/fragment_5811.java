if (wordCount >= 4){
            for (int i = 0; i <charCount-3; i++){
                    int space = sentence.indexOf(" ");
                    if(space==-1){// check if space is -1
                        break;
                    }   
                    System.out.println(i+ " " + space);
                    int endSpace = space + 1;
                    sentence = sentence.substring(0, space)
                            + "\n"
                         + sentence.substring(endSpace, sentence.length()-1);
                    }
                    System.out.println(sentence);