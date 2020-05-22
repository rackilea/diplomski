class Converter implements Callable<IVideoPicture> {
  // ... variables and constructor

  public IVideoPicture call() {
    return convert(this.image);
  }
}