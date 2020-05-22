public class Signup {
  boolean isStealthEnabled;
  Reg signup;
  public Signup(boolean b)
  {
    this.isStealthEnabled = b;
    this.signup = new Reg(isStealthEnabled);
    System.out.println("Value of b inside \"Signup\" " + b);
  }
}