private static class SpeedTest {
        private static final Map<String, List> arrays = new HashMap<String, List>();

        public static void test(final double[] array) throws IOException, ClassNotFoundException {
            final String str = serialize(array);
            final int amount = 10 * 1000;

            long timeStamp = System.currentTimeMillis();
            for (int i = 0; i < amount; i++) {
                serialize(array);
            }
            System.out.println("Serialize: " + (System.currentTimeMillis() - timeStamp) + " ms");

            timeStamp = System.currentTimeMillis();
            for (int i = 0; i < amount; i++) {
                deserialize(str);
            }
            System.out.println("Deserialize: " + (System.currentTimeMillis() - timeStamp) + " ms");

            arrays.clear();
            timeStamp = System.currentTimeMillis();
            // Prepaire map, that contains reference for all arrays.
            for (int i = 0; i < amount; i++) {
                arrays.put("key_" + i, Arrays.asList(array));
            }
            // Getting array by its key in map.
            for (int i = 0; i < amount; i++) {
                arrays.get("key_" + i).toArray();
            }
            System.out.println("Mapping: " + (System.currentTimeMillis() - timeStamp) + " ms");
        }
    }