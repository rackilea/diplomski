public Cursor getWorkoutExercises(long exerciseid){
    String[] columns = new String[]{EXERCISE_ID + " AS _id","*"}
    return this.getWritableDatabase().query(TABLE_EXERCISE, columns,
            EXERCISE_ID+"=?",
            new String[]{Long.toString(exerciseid)},
            null,null,null);

}