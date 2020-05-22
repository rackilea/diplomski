public interface CommonMessages extends Messages {

  public static final CommonMessages INSTANCE = GWT.create( CommonMessages.class );

  @DefaultMessage( "The entered text \"{0}\" contains the illegal character(s) \"{1}\" ." )
  String textValidatorError( String o, String e );

  @DefaultMessage( "The entered text \"{0}\" contains illegal character(s)." )
  @Key("textValidatorErrorAlternate")
  String textValidatorError( String o );
}