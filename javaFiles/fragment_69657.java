Set<Integer> validValues = new HashSet<>();
for (int i = 0; i < input.length; ++i) {
  validValues.add(i);
}

for (int i = 0; i < Array_of_key.length; i++) {
    for (y = 0; y < SortedKey.length; y++) {
        if (Array_of_key[i] == SortedKey[y] && validValues.contains(y)) {
            Array_of_indexKey[i] = y;
            validValues.remove(y);
            break; // this is very important, without it you get 21403
        }
    }
}