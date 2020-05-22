private Set<Person> personSet = new HashSet<>();

   public void addBid(String ItemName, String nameOfBidder, long price){
        Person person = new Person(nameOfBidder);
        personSet.add(person);
        // do whatever you want inside this method
        // in the whole class you can access the personSet as you want.
     }