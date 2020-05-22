public static void main(String[] args) {

    HashMap db = new HashMap();
    db.put(0, "zero");
    db.put(1, "one");
    db.put(2, "two");
    db.put(3, "three");

    Hashtable hashsample = new Hashtable();

    for (int i = 0; i < db.size(); i++) {

            hashsample.put(i, db.get(i));
            System.out.println(hashsample);
    }

}