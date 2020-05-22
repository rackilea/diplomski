Tuple[] tups = new Tuple[array.length];

for (int i = 0; i < array.length; i++)
    tups[i] = new Tuple(array[i], i);

Arrays.sort(tups);

for (int i = 0; i < array.length; i++)
    array[i] = tups[i].pos + 1;