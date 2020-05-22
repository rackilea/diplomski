public abstract class Vehicle {
  public final String mName;
  public final int mNumWheels;

  protected Vehicle(String name, int numWheels){
    this.mName = name;
    this.mNumWheels = numWheels;
  }

  public void reportProblem(String problem){
    ReportUtil.reportVehicleInfo(mName, mNumWheels, problem);
  }
  ...
}