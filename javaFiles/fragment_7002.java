public class Section{
  public String color;
  public List<Section> sub_sections;

  /** Propagates the current section color to all sub sections. */
  public void propagate() {
    propagate(this.color);
  }

  /** Propagates the passed color to this section and all sub sections recursively. */
  private void propagate(String propagatedColor) {
    color = propagatedColor;
    for (Section sub : sub_sections) {
      sub.propagate(propagatedColor);
    }
  }

}