public class Data{
  public final int crns;
  public final String name;
  public final String department;
  public final int year;

  public Data(int crns, String name, String department, int year){
    this.crns = crns;
    this.name = name;
    this.department = department;
    this.year = year;
  }

  public String toString(){
    return crns + "," + name + "," + department + "," + year;
  }
}