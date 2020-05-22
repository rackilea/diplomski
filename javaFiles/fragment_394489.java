public class HeresYourDoubleStack {
  private int size = 0;
  private double[] values= new double[16];

  public int size() {
    return size;
  }

  public double pop() {
    if(size==0)throw new NoSuchElementException();
    return values[size--];
  }

  public void push(double value) {
    resizeIfNecessary();
    values[size++]=value;
  }

  private void resizeIfNecessary() {
    if(values.length==size){
      double[] tmp = new double[size * 2];
      System.arraycopy(values,0,tmp,0,size);
      values=tmp;
    }
  }
}