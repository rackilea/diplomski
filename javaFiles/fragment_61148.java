class Tree {

    ...
    public List<String> matches(CharSequence prefix) {
        List<String> result = new ArrayList<>();
        if(r != null) {
            Node n = r._match(prefix, 0);
            if(n != null) {
                StringBuilder p = new StringBuilder();
                p.append(prefix);
                n._addWords(p, result);
            }
        }
        return result;
    }
}

class Node {

    ...
    protected Node _match(CharSequence prefix, int index) {
        assert index <= prefix.length();
        if(index == prefix.length()) {
            return this;
        }
        int val = prefix.charAt(index) - 'a';
        assert val >= 0 && val < letter.length;
        if (letter[val] != null) {
            return letter[val].match(prefix, index+1);
        }
        return null;
    }

    protected void _addWords(StringBuilder prefix, List<String> result) {
        if(this.flag) {
            result.add(prefix.toString());
        }    
        for(int i = 0; i<letter.length; i++) {
            if(letter[i] != null) {
                prefix.append((char)(i + 'a'));
                letter[i]._addWords(prefix, result);
                prefix.delete(prefix.length() - 1, prefix.length());
            }
        }
    }
}