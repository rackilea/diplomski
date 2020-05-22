public static void main (String[] args) throws java.lang.Exception
{
  String authors = "J. Park and J. N. James and Q. Li and Y. Xu and W. Huang";
  String authorName = "James";

  String[] parts = authors.split(" and ");

  for (String p : parts) {
    if (p.contains(authorName)) {
      System.out.println(p);
    }
  }
}