Integer[] arr = {3,6,7,11,20};
List<Integer> shuffled = new ArrayList<>();
for (int j = 0; j < x; j++)
    for (Integer i : arr)
        shuffled.add (i);
Collections.shuffle(shuffled); // shuffle the List to get random order