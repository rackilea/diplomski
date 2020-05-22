class Pair<F,S> {
    private F first;
    private S second;

    Pair(F first, S second){
       this.first = first;
      this.second= second;
    }

   public F getFirst(){
   return first;
   }

   public S getSecond(){
   return second;
   }
}