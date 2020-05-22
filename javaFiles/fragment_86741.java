public class LinkedList<E extends Comparable<E>> {
    private Node start = null;

    private class Node{
        private E value = null;
        private Node next = null;
    }

    public void insert(E newValue){
        // code here, e.g.
        //   node.getValue().compareTo(newValue)
    }
}

public class Word implements Comparable<Word>{
    private String stringWord;
    private LinkedList<String> variations;

    @Override
    public int compareTo(Word that){
        return this.stringWord.compareTo(that.stringWord);
    }
}

// main list
LinkedList<Word> words;