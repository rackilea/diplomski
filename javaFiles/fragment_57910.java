if (generated.size() < max - min + 1) {
    if (generated.contains(String.valueOf(qran))) {
        RandomizeQuestion();
    } else {
        generated.add(String.valueOf(qran));
    }
}