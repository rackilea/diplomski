class MyClass implements Comparable<MyClass> {
   private String word;
   private double score;

   MyClass(String word, double score) {
       this.word = word;
       this.score = score;
   }

   @Override
   public int compareTo(MyClass o) {
      return (int) Math.round(Math.signum(score - o.score));
   }

}