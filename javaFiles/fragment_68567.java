ResultSet result = Querying.ontologyQuery(Strings.getFeatured());
while (result.hasNext()) {
    QuerySolution qs = result.next();
    Resource exercise = qs.getResource("Exercise");
    Resource mainMuscle = qs.getResource("mainMuscle");
    Literal equipment = qs.getLiteral("Equipment");
    vbox.getChildren().add(new ExerciseView(exercise, mainMuscle, equipment));
}