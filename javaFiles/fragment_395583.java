public enum Paperless{
  NONE( null ),
  RECOMMENDED_DELIVERY( "Recommended delivery" ),
  ...//put here the other values
  REQUIRED_DELIVERY( "Required delivery" );
  private String name;
  Paperless( String name ){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
}