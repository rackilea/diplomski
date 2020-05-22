public static void serialize(WorkoutLog workoutLog, File filename) {

    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    try {
      fos = new FileOutputStream(filename);
      out = new ObjectOutputStream(fos);
      out.writeObject(workoutLog);

      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

}

public static WorkoutLog deserialize(File filename) {
    FileInputStream fis = null;
    ObjectInputStream in = null;
    WorkoutLog workout = null;
    try {
      fis = new FileInputStream(filename);
      in = new ObjectInputStream(fis);
      workout = (WorkoutLog) in.readObject();
      in.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return workout;
}