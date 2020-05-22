final class Die
{

  private final Map<Integer, Character> die = new HashMap<>();

  Die(CharSequence faces)
  {
    for (int idx = 0; idx < faces.length(); ++idx)
      die.put(idx + 1, faces.charAt(idx));
  }

  SortedMap<Integer, Character> facesToLetters()
  {
    return new TreeMap<>(die);
  }

  public static void main(String... argv)
    throws Exception
  {
    Die die = new Die("CMIOUT");
    System.out.println(die.facesToLetters());
  }

}