String[] inputs = { "AA", "BB" };
Pattern p = Pattern.compile("AAAAAB");
Matcher m = p.matcher("");
for (String s : inputs)
{
  m.reset(s);
  System.out.printf("%s -- full match: %B; partial match: %B%n",
                    s, m.matches(), m.hitEnd());
}