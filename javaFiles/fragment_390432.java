public String sampleMethod(){
  return findResult(new SampleOperation(){
    @Override
    private String perform() {
      return "result";
    }
  });
}

private String findResult(SampleOperation op){
  return op.perform();
}

private static interface SampleOperation {
  String perform();
}