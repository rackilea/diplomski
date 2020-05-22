@Test
public void test()
{
    String string = "13:46 Kill: 6 2 6: Zeh killed Isgalamido by MOD_ROCKET";
    String regexp = "\\d+:\\d+ .*?([A-Za-z0-9]+) killed ([A-Za-z0-9]+).*?";
    String player1 = null;
    String player2 = null;

    Pattern p = Pattern.compile(regexp);

    Matcher m = p.matcher(string);

    if (m.find())
    {
        player1 = m.group(1);
        player2 = m.group(2);
    }

    assertEquals("Zeh", player1);
    assertEquals("Isgalamido", player2);
}