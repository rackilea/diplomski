private static Vector<Hashtable<Character, String>> vector1;
private static Vector<Hashtable<Character, String>> vector2;
private static Vector<Hashtable<Character, String>> vector3;

public static void main(final String[] args) {
    setUp();

    // Your final vector
    Vector<Hashtable<Character, String>> mergedVector = new Vector<Hashtable<Character, String>>();

    // Considering every vector has the same size
    addToMerged(mergedVector, vector1);
    addToMerged(mergedVector, vector2);
    addToMerged(mergedVector, vector3);

    // Print the result
    for (Hashtable<Character, String> hash : mergedVector) {
        for (Entry<Character, String> set : hash.entrySet()) {
            System.out.println("KEY: " + set.getKey() + ", VALUE: "
                + set.getValue());
        }

        System.out.println("\nNext hashtable.\n");
    }
}

private static void setUp() {
    vector1 = new Vector<Hashtable<Character, String>>();
    Hashtable<Character, String> hash11 = new Hashtable<Character, String>();
    hash11.put('a', "Prity");
    hash11.put('b', "Joshi");
    hash11.put('c', "Pyarelal");
    hash11.put('d', "1");
    vector1.add(hash11);

    Hashtable<Character, String> hash12 = new Hashtable<Character, String>();
    hash12.put('a', "tiny");
    hash12.put('b', "darji");
    hash12.put('c', "Mohandas");
    hash12.put('d', "2");
    vector1.add(hash12);

    vector2 = new Vector<Hashtable<Character, String>>();
    Hashtable<Character, String> hash21 = new Hashtable<Character, String>();
    hash21.put('e', "age-29");
    hash21.put('f', "height-5");
    hash21.put('d', "1");
    vector2.add(hash21);

    Hashtable<Character, String> hash22 = new Hashtable<Character, String>();
    hash22.put('e', "age-52");
    hash22.put('f', "height-6");
    hash22.put('d', "2");
    vector2.add(hash22);

    vector3 = new Vector<Hashtable<Character, String>>();
    Hashtable<Character, String> hash31 = new Hashtable<Character, String>();
    hash31.put('g', "pet-dog");
    hash31.put('d', "1");
    vector3.add(hash31);

    Hashtable<Character, String> hash32 = new Hashtable<Character, String>();
    hash32.put('g', "pet-cat");
    hash32.put('d', "2");
    vector3.add(hash32);
}

private static void addToMerged(
    final Vector<Hashtable<Character, String>> mergedVector,
    final Vector<Hashtable<Character, String>> vector) {
    for (int i = 0; i < vector.size(); i++) {
        Hashtable<Character, String> hashtable = vector.get(i);
        for (Entry<Character, String> entrySet : hashtable.entrySet()) {
    boolean added = false;
    for (int j = 0; j < mergedVector.size() && !added; j++) {
        Hashtable<Character, String> hashtable2 = mergedVector
            .get(j);
        if (!hashtable2.containsKey(entrySet.getKey())) {
            hashtable2.put(entrySet.getKey(), entrySet.getValue());
            added = true;
            break;
        } else if (hashtable2.get(entrySet.getKey()).equals(
            entrySet.getValue())) {
            added = true;
            break;
        }
    }
    if (!added) {
        Hashtable<Character, String> hashtable2 = new Hashtable<>();
        hashtable2.put(entrySet.getKey(), entrySet.getValue());
            mergedVector.add(hashtable2);
    }
    }
}
}