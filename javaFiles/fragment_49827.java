public class Dawg {
  // All my children.
  Dawg[] children = new Dawg[256];
  // Am I a leaf.
  boolean isLeaf = false;

  // Add a new word.
  public void add ( byte[] word ) {
    // Finds its location, growing as necessary.
    Dawg loc = find ( word, 0, true );
    loc.isLeaf = true;
  }

  // String form.
  public void add ( String word ) {
    add(word.getBytes());
  }

  // Returns true if word is in the dawg.
  public boolean contains ( byte [] word ) {
    // Finds its location, no growing allowed.
    Dawg d = find ( word, 0, false );
    return d != null && d.isLeaf; 
  }

  // String form.
  public boolean contains ( String word ) {
    return contains(word.getBytes());
  }

  // Find the Dawg - growing the tree as necessary if requested.
  private Dawg find ( byte [] word, int i, boolean grow ) {
    Dawg child = children[word[i]];
    if ( child == null ) {
      // Not present!
      if ( grow ) {
        // Grow the tree.
        child = new Dawg();
        children[word[i]] = child;
      }
    }
    // Found it?
    if ( child != null ) {
      // More to find?
      if ( i < word.length - 1 ) {
        child = child.find(word, i+1, grow);
      }
    }
    return child;
  }

  public static void main ( String[] args ) {
    Dawg d = new Dawg();
    d.add("H");
    d.add("Hello");
    d.add("World");
    d.add("Hell");
    System.out.println("Hello is "+(d.contains("Hello")?"in":"out"));
    System.out.println("World is "+(d.contains("World")?"in":"out"));
    System.out.println("Hell is "+(d.contains("Hell")?"in":"out"));
    System.out.println("Hal is "+(d.contains("Hal")?"in":"out"));
    System.out.println("Hel is "+(d.contains("Hel")?"in":"out"));
    System.out.println("H is "+(d.contains("H")?"in":"out"));
  }
}