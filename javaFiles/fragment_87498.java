class PercolationStats {
 public static void main(String[] args){
  new PercolationStats ();
 }

 public PercolationStats() {
  System.out.println("-- Summary --\n");
  System.out.printf("mean\tstdev\t[lo\thi]\n\n");
  System.out.printf("%1.3f\t%.3f\t%.3f\t%.3f", mean(), 
                          stddev(), confidenceLo(), confidenceHi());

  System.out.println("-- End --");
 }
}