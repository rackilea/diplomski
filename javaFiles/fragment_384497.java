class QuadPoly extends Poly{
  public QuadPoly(){ super(2); }
  public QuadPoly(float[] f){
    super(f);
    if(coefficients.length!=2) throw new IllegalArgumentException("not quad");
  }
}