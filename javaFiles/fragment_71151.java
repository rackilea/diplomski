public class Stripper
{
  public static void main (String[] args)
  {
    String c = "coins<col=ffffff> x <col=ffff00>";
    String c2 = "coins<col=ffffff> x <col=ffffff>100k (100,000)";
    String c3 = "coins<col=ffffff> x <col=00ff80>10m (10,000,000)";

    String stripped = strip (c);
    if (!stripped.isEmpty ())
      System.out.println (Integer.parseInt (stripped));

    String stripped2 = strip (c2);
    if (!stripped2.isEmpty ())
      System.out.println (Integer.parseInt (stripped2));

    String stripped3 = strip (c3);
    if (!stripped3.isEmpty ())
      System.out.println (Integer.parseInt (stripped3));
  }

  private static String strip (String text)
  {
    int first = text.indexOf ('(');
    if (first < 0)
      return "";

    int last = text.indexOf (')', first);
    if (last < 0)
      return "";

    return text.substring (first + 1, last).replaceAll (",", "");
  }
}