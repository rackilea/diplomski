CSVReader reader = new CSVReader(new FileReader(filename));
    java.util.List<String[]> content = reader.readAll();
    Map<String, Group> groups = new HashMap<>();
    for(String[] row : content)
    {
        String Name = row[0];
        String Miles = row[1];

        System.out.printf("%s has ran %s miles %n", Name, Miles);

        if (groups.containsKey(Name)){
            groups.get(Name).Add(Double.valueOf(Miles));
        } else {
            Group g = new Group();
            g.Add(Double.valueOf(Miles));
            groups.put(Name, g);
        }
    }
    reader.close();

    for (String name : groups.keySet())
    {
        System.out.println(name + " ran " + groups.get(name).total() + " with avg of " + groups.get(name).average());
    }


}

class Group {
    private List<Double> miles;

    public Group()
    {
        miles = new ArrayList<>();
    }

    public Double total(){
        double sum = 0;
        for (Double mile : miles)
        {
            sum += mile;
        }
        return sum;
    }

    public Double average(){
        if (miles.size() == 0)
            return 0d;            
        return total() / miles.size();
    }

    public void Add(Double m){
        miles.add(m);
    }
}