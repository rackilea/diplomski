public Map<String, ArrayList<String>> getSections ()
{
    Map<String, ArrayList<String>> sections = new HashMap<>();
    String s = "", lastKey = "";
    try (BufferedReader br = new BufferedReader(new FileReader("input.txt")))
    {
        while ((s = br.readLine()) != null)
        {
            String k = s.substring(0, 10).trim();
            String v = s.substring(10, s.length() - 50).trim();
            if (k.equals(""))
                k = lastKey;

            ArrayList<String> authors = null;
            if (sections.containsKey(k))
            {
                authors = sections.get(k);
            }
            else
            {
                authors = new ArrayList<String>();
                sections.put(k, authors);
            }

            // don't add empty strings
            if (v.length() > 0)
            {
                authors.add(v);
            }
            lastKey = k;
        }
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    return sections;
}