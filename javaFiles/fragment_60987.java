Exercise[] exercises = loadExercises(SavingData.getDifficulty());
if (exercises == null) {
    // no exercises were loaded
    // maybe create default exercises here?

} else {
    myExercises = new FitnessExercise(exercises);
    myExercises.randomize();
    maxExercises = myExercises.nbrOfExercises();
    nextExercise();
}