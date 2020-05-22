public List<List<Task>> forwardDependencies(
        List<Task> tasks,
        List<List<Task>> dependencies
    ) {
    List<List<Task>> forwardDependencies = new ArrayList<>();

    for (Task task : tasks) {
        List<Task> forwardDependency = new ArrayList();
        for (int i = 0; i < dependencies.size(); i++) {
            List<Task> dependency = dependencies.get(i);
            if (dependency.contains(task)) {
                forwardDependency.add(tasks.get(i));
            }
        }
        forwardDependencies.add(forwardDependency);
    }
    return forwardDependencies;
}