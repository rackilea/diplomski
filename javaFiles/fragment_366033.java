int[] array = {4, 3, 1, 2};
boolean[] mask = {true, false, false, true};

int[] result = IntStream.range(0, array.length)
                        .filter(i -> mask[i])
                        .map(i -> array[i])
                        .toArray();