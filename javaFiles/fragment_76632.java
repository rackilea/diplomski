List<Integer> indices = map.get(name);
    int maxScore = 0, maxIndex = 0;

    for (int index: indices) {
        if (grades[index] > maxScore) {
            maxIndex = index;
        }
    }