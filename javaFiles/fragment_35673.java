db.execSQL("create table " + TermDbSchema.CourseTable.NAME + "(" +
            "_id integer primary key autoincrement, " +
            TermDbSchema.CourseTable.Cols.UUID + ", " +
            TermDbSchema.CourseTable.Cols.TITLE + ", " +
            TermDbSchema.CourseTable.Cols.START_DATE + ", " +
            TermDbSchema.CourseTable.Cols.END_DATE + ", " +
            TermDbSchema.CourseTable.Cols.COURSE_STATUS + ", " +
            TermDbSchema.CourseTable.Cols.OPTIONAL_NOTE + ", " +
            TermDbSchema.CourseTable.Cols.MENTOR_NAME + ", " +
            TermDbSchema.CourseTable.Cols.MENTOR_PHONE + ", " +
            TermDbSchema.CourseTable.Cols.MENTOR_EMAIL + ", " + //<<<<<<<<<< CHANGED
            TermDbSchema.CourseTable.Cols.TERM_LINK + " INTEGER REFERENCES " + TermDbSchema.TermTable.NAME + "(_id)" + //<<<<<<<<<< ADDED

            ")"
    );