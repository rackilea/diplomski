public static void main(String[] args) {
    Trie trie = new Trie();
    trie.add("at");
    trie.add("Hello");
    System.out.println(trie.find("at"));
    System.out.println(trie.find("Hello"));
    System.out.println(trie.find("yea"));
}