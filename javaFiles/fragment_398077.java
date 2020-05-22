class Suffix implements Comparable<Suffix>
{
   int index;
   String suff;

  @Override
  public int compareTo(Suffix o) {

     return this.suff.compareTo(o.suff);
  }
}