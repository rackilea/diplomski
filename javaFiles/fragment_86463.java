public abstract class Addable<T extends Number,U extends Addable<T,U>> {
  private final T value;
  public Addable( final T value ){ this.value = value; }
  public T getValue(){ return value; }
  public abstract U add( U addend );
}