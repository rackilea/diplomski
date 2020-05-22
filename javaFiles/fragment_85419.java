public String teenTalk(String sentence) {
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < sentence.length(); i++) {
           if(sentence.charAt(i) == ' '){
              builder.append(" like ");
           }else{
              builder.append(sentence.charAt(i));
           }
       }
       return builder.toString();
}