private enum Method {
    CONTAINS,
    EQUALS;
}

@Test
public void testFruits() throws IOException {
    Map<String, Method> methodByFruit = new HashMap<>();
    methodByFruit.put("apple", Method.CONTAINS);
    methodByFruit.put("pear", Method.CONTAINS);
    methodByFruit.put("grenade apple", Method.CONTAINS);
    methodByFruit.put("banana", Method.EQUALS);
    methodByFruit.put("kiwi", Method.EQUALS);

    BufferedReader in = new BufferedReader(new StringReader("kiwi2"));

    String line;
    while ((line = in.readLine()) != null) {
        boolean success = false;
        for (Entry<String, Method> entry : methodByFruit.entrySet()) {
            String fruit = entry.getKey();
            Method method = entry.getValue();
            if (method == Method.EQUALS) {
                success = line.equals(fruit);
            } else {
                success = line.contains(fruit);
            }
            if (success) {
                break;
            }
        }
        if (!success) {
            System.out.println("DO SOMETHING");
        }
    }
}