public partial class Employee : TBase
{
  private string _name;
  private string _surname;
  private int _age;

  // properties
  public string Name {... }
  public string Surname  { ... }
  public int Age  { ... }

  // some details omitted

  public void Read (TProtocol iprot)
  {
    // generated code for Read() method
  }

  public void Write(TProtocol oprot) {
    // generated code for Write() method
  }

  public override string ToString() {
    // generated code for ToString() method
  }

}