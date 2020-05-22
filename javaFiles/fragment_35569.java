private static final String GET_NOT_DISPERSED = "select * from Assignments where "
                                            + Assignments.CLOSE_DATE + "<=? and " 
                                            + Assignments.PEER_START_DATE + ">=? and "
                                            + Assignments.ID + " not in(select " + Assignments.ID + " from RevisionDispersion)";
private void makeMailDispersion() throws Exception
{
    DateTime currentDate = DateTime.getCurrentDateTime();

    PreparedStatement assignmentsStmt = null;
    ResultSet assignments = null;
    Connection con = null;

    try{
        con = source.getConnection();
        configureConnection(con);
        assignmentsStmt = con.prepareStatement(GET_NOT_DISPERSED);
        assignmentsStmt.setString(1, currentDate.toString());
        assignmentsStmt.setString(2, currentDate.toString());

        assignments = assignmentsStmt.executeQuery();

        ArrayList<Assignment> requiresDispersion = new ArrayList<>();

        assignments.close();
        assignmentsStmt.close();
        while(assignments.next())
        {
            Assignment assignment = new Assignment(source.getConnection(), assignments.getString(Assignments.ID));
            AssignmentDisperser.disperse(source, assignment);
        }
    }catch(Exception e){
        throw e;
    }finally{
        closeQuietly(con, assignmentsStmt, assignments);
    }
}