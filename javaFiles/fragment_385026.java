if(textScanner == null)
{
  state.setTm(tm);

  if(this instanceof ShowTextToNextLine)
    state.getTlm().concatenate(new AffineTransform(1, 0, 0, 1, 0, -state.getLead()));
}