public class AddableInteger extends Addable<Integer,AddableInteger> {
  public AddableInteger( final Integer value ){
    super( value );
  }

  @Override
  public AddableInteger add( final AddableInteger addend ){
    java.util.Objects.requireNonNull( addend );
    return new AddableInteger( this.getValue() + addend.getValue() );
  }
}