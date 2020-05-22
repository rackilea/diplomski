// thia is the actual Workoutlog

public WorkoutLog(){
    mWorkoutLog = new TreeMap<>();
}
//the string key will be the workouts formatted date
public TreeMap < String, Workout> getWorkoutLog(){
    return mWorkoutLog;
}