private final List<String> backList = new ArrayList<>();
private final List<String> chestList = new ArrayList<>();
private final List<String> legList = new ArrayList<>();
…
private String[] backDay() {
    if (backList.isEmpty()) {
        backList.add("Deadlift");
        …
    }
    return randomExercises(backList);
}
…