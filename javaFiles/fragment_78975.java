public static void main(String[] args) throws IOException, ClassNotFoundException {
    WorkoutLog workoutLog = new WorkoutLog();
    Workout workout = new Workout();
    /* I had path to workout.txt as D:\\workout.txt*/
    File file = new File("D:\\workout.txt");

    workoutLog.getWorkoutLog().put(workout.getDate(),workout);
    SerializationUtil.serialize(workoutLog,file);
    System.out.println("Workout saved in..." +file.getName());

    workoutLog = (WorkoutLog) SerializationUtil.deserialize(file);
    System.out.println("Deserializing from:..." + file.getName());
    System.out.println(workoutLog.getWorkoutLog().keySet()+"");

}