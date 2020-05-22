case WORkOUT_EXERCISE:
        final String QUERY = "SELECT workouts._id, " +
                "exercise_name," +
                "weight," +
                "reps," +
                "rpe"+
                " FROM "+
                "exercises"+
                " INNER JOIN workouts ON workouts._id = exercises.workout_id"+
                " WHERE workouts._id=?";
       cursor = db.rawQuery(QUERY, selectionArgs);
        break;