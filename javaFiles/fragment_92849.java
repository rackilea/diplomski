abstract class Fluid{
  public String getTemp(){
    return "unknown";
  }
}
class Coffee extends Fluid{
  public String getTemp(){
    return "hot";
  }
}
class Cola extends Fluid{
  public String getTemp(){
    return "ice-cold"
  }
}

Fluid cup = new Coffee();
System.out.println(cup.getTemp()); //It's coffe in there, so it's hot!