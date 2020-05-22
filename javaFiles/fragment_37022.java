public static void main(String[]args){
    HashMap<Integer, Offer> map = new HashMap<Integer, Offer>();

    // First way
    map.put(1038, new Offer(1038, "foo", 10.20, "bar", new Date()));

    // Second way
    Offer o1 = new Offer(1038, "foo", 10.20, "bar", new Date());
    map.put(o1.getId(), o1);

}