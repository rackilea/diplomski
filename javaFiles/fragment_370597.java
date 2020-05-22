public void Or(BinaryMap source, RectangleC area, Point at) {
  Combine(source, area, at, new CombineFunction() {
    @Override
    public void combine(int[] target, int[] srcVector) {
      for (int i = 0; i < target.length; ++i)
        target[i] |= srcVector[i];
    }
  });
}