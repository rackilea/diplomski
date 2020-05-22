int x = ...;
int y = ...;
int[][] array = new int[x][y];

Map<SomeClass, Integer> index = new HashMap<>();
for(int i = 0; i < Math.max(x, y); i++) {
    SomeClass m = ...; // object associated with i
    index.put(m, i);
}

SomeClass obj = ...;

// accessing the array
array[index.get(obj)][index.get(obj)] = 1;