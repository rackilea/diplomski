private int getWordCount(String word,String source){
        int count = 0;
        {
            Pattern p = Pattern.compile(word);
            Matcher m = p.matcher(source);
            while(m.find()) count++;
        }
        return count;
    }