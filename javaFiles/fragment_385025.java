if(textScanner == null)
{
  state.setTm(tm);

  if(this instanceof ShowTextToNextLine)
  {state.setTlm((AffineTransform)tm.clone());}
}