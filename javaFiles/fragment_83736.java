// See if there is a Trie edge for the current character
    if (child.containsKey(ch)) {
        result += ch;          //Update result
        crawl = child.get(ch); //Update crawl to move down in Trie

        // If this is end of a word, then update prevMatch
        if (crawl.isEnd()) {
            prevMatch = level + 1;
        }
    } else {
        break;
    }