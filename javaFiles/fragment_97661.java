case WORkOUT_EXERCISE:

        String table = WorkoutContract.WorkoutEntry.TABLE_NAME_EXERCISES +
            " INNER JOIN " + WorkoutContract.WorkoutEntry.TABLE_NAME_WORKOUT +
            " ON " + WorkoutContract.WorkoutEntry.TABLE_NAME_WORKOUT + "." +
            WorkoutContract.WorkoutEntry._ID + " = " +
            WorkoutContract.WorkoutEntry.TABLE_NAME_EXERCISES + "." +
            WorkoutContract.WorkoutEntry.WORKOUT_ID;


        String[] columns = new String[]{
            WorkoutContract.WorkoutEntry.EXERCISE_NAME,
            WorkoutContract.WorkoutEntry.WEIGHT,
            WorkoutContract.WorkoutEntry.REPS,
            WorkoutContract.WorkoutEntry.RPE               
        };

        String whereclause = WorkoutContract.WorkoutEntry._ID + " =?";

        cursor = db.query(table,columns,whereclause,selectionArgs,null,null,null);
        break;