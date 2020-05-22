else{ //i == s.length - 1
        if(temp.links[t] == null) {
            temp.links[t] = new TrieNode((char) (97+t), true, null);    
        } 
        else {
            // change the leaf tag from false to true 
        }
    }