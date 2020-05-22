public class Test{

  public int[] a;

  /*@ public normal_behavior
  @ ensures (\forall int x; 0<=x && x<a.length; a[x]==1); // method post-condition
  @ diverges true; // not necessary terminates
  @*/
  public void fillArray() {
    int i = 0;

    /*@ loop_invariant
    @ 0 <= i && i <= a.length &&  // i ∈ [0, a.length]
    @ (\forall int x; 0<=x && x<i; a[x]==1); // x ∈ [0, i) | a[x] = 1
    @ assignable a[*]; // Valid array location
    @*/
    while(i < a.length) {
      a[i] = 1;
      i++;
    }
  }

}