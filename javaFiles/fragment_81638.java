public class FrameAdopter<T extends SampleFrame> extends WindowAdapter
{
  T sf;
  public FrameAdopter(T sf)
  {
    this.sf= sf;
  }
}