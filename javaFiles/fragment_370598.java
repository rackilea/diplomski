class MyCombineFunction implements CombineFunction {

  @Override
  public void combine(int[] target, int[] srcVector) {
    for (int i = 0; i < target.length; ++i)
      target[i] |= srcVector[i];
  }

}