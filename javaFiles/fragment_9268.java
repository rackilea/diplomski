while(st.hasMoreTokens()){
        String s = st.nextToken();
      for(int a = 0; a < searchWords.length; a++){
        if(searchWords[a].getWord().equals(s)){
          searchWords[a].incCount();
        }   
      }