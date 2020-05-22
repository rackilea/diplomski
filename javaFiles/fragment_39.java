public class K { 
  private String s;
  public K(String s) { this.s = s; }
  public void setS(String s) { this.s = s; }
  public boolean equals(Object o) { return ((K)o).s.equals(this.s); }
  public int hashCode() { return s.hashCode(); }