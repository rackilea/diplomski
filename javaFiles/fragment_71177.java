class SchemaFactory
{
  public static Schema getSchema(String type, String json)
  {
    if ( type.equals("account") )
      return new AccountSchema(json);
    else if ( type.equals("contact") )
      return new ContactSchema(json);
    else if ( type.equals("order") )
      return new OrderSchema(json);

    throw new IllegalArgumentException();
  }
}