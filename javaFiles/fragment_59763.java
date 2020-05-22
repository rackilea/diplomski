public class FunctionPlotter implements EntryPoint {
  public static class ArbitraryFunctionData {
    private double xValue;
    private Map<String, Double> yValues = new HashMap<String, Double>();
    public double get(String key) {
      return yValues.get(key);
    }
    public void put(String key, double yValue) {
      yValues.put(key, yValue);
    }
    public double getXValue() {
      return xValue;
    }
    public void setxValue(double xValue) {
      this.xValue = xValue;
    }
  }
  public interface AFDProperties extends PropertyAccess<ArbitraryFunctionData> {
    //xvalue is unique, key off of that
    @Path("xValue")
    ModelKeyProvider<ArbitraryFunctionData> key();

    //automatic ValueProvider generation for the get/setXValue methods
    ValueProvider<ArbitraryFunctionData, Double> xValue();
  }

  /** 
   * This is really doing two different jobs at once - wasn't quite was I was trying to suggest in 
   * that other question. See the second version of this for clarification...
   */
  public static abstract class ArbitraryFunction implements ValueProvider<ArbitraryFunctionData, Double> {
    private final String field;

    public ArbitraryFunction(String field) {
      this.field = field;
    }

    public abstract Double f(Double x);

    @Override
    public Double getValue(ArbitraryFunctionData object) {
      return object.get(field);
    }

    @Override
    public void setValue(ArbitraryFunctionData object, Double value) {
      object.put(field, value);
    }

    @Override
    public String getPath() {
      return field;
    }
  }

  @Override
  public void onModuleLoad() {
    Viewport vp = new Viewport();

    Set<ArbitraryFunction> functions = new HashSet<ArbitraryFunction>();
    ArbitraryFunction f1 = new ArbitraryFunction("f1") {
      @Override
      public Double f(Double x) {
        return Math.sin(x);
      }
    };
    functions.add(f1);

    AFDProperties props = GWT.create(AFDProperties.class);
    ListStore<ArbitraryFunctionData> store = new ListStore<ArbitraryFunctionData>(props.key());
    // collects the data of the functions and adds them to the store
    for (Double x = 0.0; x <= 2 * Math.PI; x = x + 0.1) {
      // Create one data object, and set the X value, since that is the same for all Y values
      ArbitraryFunctionData d = new ArbitraryFunctionData();
      d.setxValue(x);

      // For each function, set the corresponding Y value
      for (ArbitraryFunction func : functions) {
        d.put(func.getPath(), func.f(x));
      }
      store.add(d);
    }

    Chart<ArbitraryFunctionData> chart = new Chart<ArbitraryFunctionData>();
    chart.setStore(store);

    //Y-axis
    NumericAxis<ArbitraryFunctionData> verticalAxis = new NumericAxis<ArbitraryFunctionData>();
    verticalAxis.setPosition(Position.LEFT);
    verticalAxis.addField(f1);//needs to know this field to properly set the range of values
    //f2, f3, etc
    verticalAxis.setSteps(2);
    verticalAxis.setMinorTickSteps(5);
    chart.addAxis(verticalAxis);

    // X-Axis, this time reading from the xValue, not the series of ValueProviders
    NumericAxis<ArbitraryFunctionData> horizAxis = new NumericAxis<ArbitraryFunctionData>();
    horizAxis.setPosition(Position.BOTTOM);
    horizAxis.addField(props.xValue());//same value for all
    horizAxis.setSteps(2);
    horizAxis.setMinorTickSteps(5);
    chart.addAxis(horizAxis);

    for (ArbitraryFunction func : functions) {
      LineSeries<ArbitraryFunctionData> line = new LineSeries<ArbitraryFunctionData>();
      // configure x axis
      line.setXAxisPosition(Position.BOTTOM);//where is it
      line.setXField(props.xValue());//what value do i use
      // configure y axis
      line.setYAxisPosition(Position.LEFT);//where is it
      line.setYField(func);//what value do i use

      //probably want to customized per func
      line.setStroke(RGB.GRAY);
      line.setStrokeWidth(2);

      chart.addSeries(line);
    }

    vp.setWidget(chart);
    RootPanel.get().add(vp);
  }
}