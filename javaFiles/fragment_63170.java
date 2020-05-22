for (int i = 0; i <= pigLatin.length(); i++) {
                    char firstChar = pigLatin.charAt(0); 
                    pigLatin = pigLatin.substring(1);
                    pigLatin = pigLatin + firstChar;
                    if (i >= pigLatin.length())
                    {
                        System.out.println(pigLatin);
                    }
                }