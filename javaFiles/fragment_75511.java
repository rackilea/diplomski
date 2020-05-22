public class AribtraryDataVP implements 
        ValueProvider<ArbitraryFunctionData, Double>() {
  private final int index;
  public AribtraryDataVP(int index) {
    this.index = index;
  }
  public Double getValue(ArbitraryFunctionData object) {
    return object.getData().get(index);
  }
  public void setValue(ArbtraryFunctionData object, Double value) {
    object.getData().set(index, object);
  }
  public String getPath() {
    return "data[" + index + "]";
  }
}