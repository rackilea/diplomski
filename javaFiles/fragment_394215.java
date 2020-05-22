public static void main(String[] args) {
         List<Float> floats = new ArrayList<>();
         floats.add(7.85f);
         floats.add(0.85f);
         floats.add(9.01f);
         floats.add(2.78f);
         Collections.sort(floats); // in ascending order, adjust sorting method as preferred - maybe you can utilize stream().sorted

         float min = floats.get(0);
         float max = floats.get(floats.size() - 1);
         int midIndex = floats.size() / 2; // Answer to #2
         float midValue = floats.get(midIndex); // Answer to #1

         System.out.println("Min: " + min + "\nMax: " + max + "\nMid index: " + midIndex + "\nMid value: " + midValue);
    }