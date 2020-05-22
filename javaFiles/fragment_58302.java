Set<Block> set = new HashSet<Block>();

boolean added = set.add( k1 );
if( added ) {
    System.out.println("Added 1 block.");
} else {
   System.out.println("Tower already contains this block.");
}