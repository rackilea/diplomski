public class problem
{
    HashMap<String, String[]> dict;

    public problem()
    {
        HashMap<String, String[]> dict = new HashMap<String, String[]>();

        // put everything into hashmap
        String[] items =
        {
            "toys", "sun"
        };
        dict.put("animal", items);
        String[] items_2 =
        {
            "fun", "games"
        };
        dict.put("human", items_2);

        this.dict = dict;

        // start
        this.BeginM();
    }

    public void BeginM()
    {
        System.out.println(this.dict.get("human")[0]); // should give "fun"
    }
}