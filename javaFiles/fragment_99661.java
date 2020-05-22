public interface Measure {
   public String getOutputAsTxt();
   public String getOutputAsCsv();
   public String getOutputAsFunnyFormat();
};

public interface AnalysisResult {

  public Measure getMeasure();

}