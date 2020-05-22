public static void main(String[] args) throws IOException 
{
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    for (int k = 0; k < a; k++) {
        String name = sc.next();
        int numer = sc.nextInt();
        map.put(name, numer);
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String name;
    while ((name = in.readLine()) != null && name.length() != 0) 
    {
        list.add(name);
    }

    for (int i = 0; i < list.size(); i++) 
    {
        if (map.containsKey(list.get(i))) 
        {
            System.out.println(list.get(i) + "=" + map.get(list.get(i)));
        } else 
        {
            System.out.println("Not found");
        }
    }
    sc.close();
}