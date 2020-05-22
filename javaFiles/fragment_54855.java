Random r = new Random(seed);
for (int i = 0; i<gen.getSize(); i++)   {   
    ArrayList<City> copy = new ArrayList<City> (city); //added from previous question
    Collections.shuffle(copy, r);
    gen.add(copy);
}