public class ColorCounterComparator implements Comparator<ColorCounter> {
  private final threshold;

  public ColorCounterComparator(final int threshold) {
    this.threshold = threshold;
  }

  @Override
  public int compare (ColorCounter c1, ColorCounter c2) {
    int cv1 = c1.getIntColorValue();
    int cv2 = c1.getIntColorValue();

    if (cv1 >= threshold && cv2 < threshold) {
       return -1;
    } else if (cv2 >= threshold && cv2 < threshold) {
       return 1;
    } else if (cv1 < cv2) {
       return -1;
    } else if (cv1 > cv2) {
       return 1;
    } else {
       return 0;    
    }
  }
}