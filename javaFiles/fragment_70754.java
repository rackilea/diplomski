Cursor cursor = sqlDB.query(TaskContract.TABLE,
            new String[]{TaskContract.Columns._ID,TaskContract.Columns.TIME, TaskContract.Columns.TASK},
            TaskContract.Columns.DATE + " = ?",
            new String[] {currentDate},
            null,
            null,
            TaskContract.Columns.TIME + " ASC");