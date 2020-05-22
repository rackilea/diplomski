Scanner sc = new Scanner(new File("test.dat"));
Pattern p = Pattern.compile("([\w\d]*)\s*");
while (sc.findWithinHorizon(p, 0) != null)
{
  MatchResult m = sc.match();
  System.out.println(m.group(1));
}