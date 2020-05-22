import java.util.concurrent.atomic.AtomicReferenceArray;


public class LFDawg {
  // All my children.
  AtomicReferenceArray<LFDawg> children = new AtomicReferenceArray<LFDawg> ( 256 );
  // Am I a leaf.
  boolean isLeaf = false;

  // Add a new word.
  public void add ( byte[] word ) {
    // Finds its location, growing as necessary.
    LFDawg loc = find( word, 0, true );
    loc.isLeaf = true;
  }

  // String form.
  public void add ( String word ) {
    add( word.getBytes() );
  }

  // Returns true if word is in the dawg.
  public boolean contains ( byte[] word ) {
    // Finds its location, no growing allowed.
    LFDawg d = find( word, 0, false );
    return d != null && d.isLeaf;
  }

  // String form.
  public boolean contains ( String word ) {
    return contains( word.getBytes() );
  }

  // Find the Dawg - growing the tree as necessary if requested.
  private LFDawg find ( byte[] word, int i, boolean grow ) {
    LFDawg child = children.get( word[i] );
    if ( child == null ) {
      // Not present!
      if ( grow ) {
        // Grow the tree.
        child = new LFDawg();
        if ( !children.compareAndSet( word[i], null, child ) ) {
          // Someone else got there before me. Get the one they set.
          child = children.get( word[i] );
        }
      }
    }
    // Found it?
    if ( child != null ) {
      // More to find?
      if ( i < word.length - 1 ) {
        child = child.find( word, i + 1, grow );
      }
    }
    return child;
  }

  public static void main ( String[] args ) {
    LFDawg d = new LFDawg();
    d.add( "H" );
    d.add( "Hello" );
    d.add( "World" );
    d.add( "Hell" );
    System.out.println( "Hello is " + ( d.contains( "Hello" ) ? "in" : "out" ) );
    System.out.println( "World is " + ( d.contains( "World" ) ? "in" : "out" ) );
    System.out.println( "Hell is " + ( d.contains( "Hell" ) ? "in" : "out" ) );
    System.out.println( "Hal is " + ( d.contains( "Hal" ) ? "in" : "out" ) );
    System.out.println( "Hel is " + ( d.contains( "Hel" ) ? "in" : "out" ) );
    System.out.println( "H is " + ( d.contains( "H" ) ? "in" : "out" ) );
  }
}