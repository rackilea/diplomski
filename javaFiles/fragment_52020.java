ThreadLocal<YourObject> threadLocalYourObject = new ThreadLocal<YourObject>() {
  @Override
  protected YourObject initialValue() {
    //initialize YourObject
  }
}