public Cursor getAllAssessmentsWithCourseAndTermdetails() {
    String tables = TermDbSchema.AssessmentTable.NAME +
            " JOIN " + TermDbSchema.CourseTable.NAME + " ON " +
            TermDbSchema.AssessmentTable.Cols.COL_ASSESS_COURSE_REFERENCE + " = " +
            TermDbSchema.CourseTable.NAME + "." + "_id" +
            " JOIN " + TermDbSchema.TermTable.NAME + " ON " +
            TermDbSchema.CourseTable.Cols.COL_COURSE_TERM_REFERENCE + " = " +
            TermDbSchema.TermTable.NAME + "." + "_id";
    return this.getWritableDatabase().query(tables,null,null,null,null,null,null);
}