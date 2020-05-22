System.out.println("Efternamn:");
name = scan.next();

List<ToA> toas = wordkey.get(name);
if (toas != null) {
  System.out.println("ToAs");
  for (ToA toa : toas) {
    System.out.println("ToA: " + toa);
  }
}
else {
  System.out.println("No ToAs found for input: " + name);
}