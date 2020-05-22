public class Facts {
  String facts [] = {
    "This is Fact 1",
    "This is fact 2",
    "This is fact 3",
 };

 int i = 0;

 public String nextFact()
{
   i++;
  return facts[i];
}
}