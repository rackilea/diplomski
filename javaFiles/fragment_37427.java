public class Problem
{
    private final HashMap<String, String[]> dict;

    public void Problem()
    {
        dict = new HashMap<String, String[]>();

        dict.put("animal", new String[] { "toys, "sun" });
        dict.put("human", new String[] { "fun", "games" });

        BeginM();
    }

    public void BeginM()
    {
        System.out.println(dict.get("human")[0]);
    }
}