public class FunctionPlotter implements EntryPoint {

  /**
   * Where did everything go? We're just making a ValueProvider now that can handle 
   * each number as a value, and working out the details from there
   *
   * For fun, added per-function coloring too
   */
  public abstract static class Function implements ValueProvider<Double, Double> {
    private final String name;
    private final Color color;
    public Function(String name, Color color) {
      this.name = name;
      this.color = color;
    }
    @Override
    public abstract Double getValue(Double object);

    @Override
    public String getPath() {
      return name;
    }
    @Override
    public void setValue(Double object, Double value) {
      //no-op
    }
    public Color getColor() {
      return color;
    }
  }

  @Override
  public void onModuleLoad() {
    Viewport vp = new Viewport();

    Set<Function> functions = new HashSet<Function>();
    Function f1 = new Function("f1", RGB.RED) {
      @Override
      public Double getValue(Double x) {
        return Math.sin(x);
      }
    };
    functions.add(f1);
    Function f2 = new Function("f2", RGB.BLACK) {
      @Override
      public Double getValue(Double x) {
        return Math.cos(x);
      }
    };
    functions.add(f2);

    //Turns out Stores can hold any objects - should probably factor out this key provider for reuse...
    ListStore<Double> store = new ListStore<Double>(new ModelKeyProvider<Double>() {
      @Override
      public String getKey(Double item) {
        return item.toString();
      }
    });
    // collects the data of the functions and adds them to the store
    for (Double x = 0.0; x <= 2 * Math.PI; x = x + 0.1) {
      store.add(x);
    }

    Chart<Double> chart = new Chart<Double>();
    chart.setStore(store);

    //Y-axis
    NumericAxis<Double> verticalAxis = new NumericAxis<Double>();
    verticalAxis.setPosition(Position.LEFT);
    for (Function func : functions) {
      verticalAxis.addField(func);//needs to know this field to properly set the range of values
    }
    verticalAxis.setSteps(2);
    verticalAxis.setMinorTickSteps(5);
    chart.addAxis(verticalAxis);

    // X-Axis, this time reading from the xValue, not the series of ValueProviders
    NumericAxis<Double> horizAxis = new NumericAxis<Double>();
    horizAxis.setPosition(Position.BOTTOM);
    horizAxis.addField(new IdentityValueProvider<Double>());//magic value provider that returns the same string
    horizAxis.setSteps(2);
    horizAxis.setMinorTickSteps(5);
    chart.addAxis(horizAxis);

    for (Function func : functions) {
      LineSeries<Double> line = new LineSeries<Double>();
      // configure x axis
      line.setXAxisPosition(Position.BOTTOM);//where is it
      line.setXField(new IdentityValueProvider<Double>());//what value do i use
      // configure y axis
      line.setYAxisPosition(Position.LEFT);//where is it
      line.setYField(func);//what value do i use

      //probably want to customized per func
      line.setStroke(func.getColor());
      line.setStrokeWidth(2);

      chart.addSeries(line);
    }

    vp.setWidget(chart);
    RootPanel.get().add(vp);
  }
}