public class PersonalDataDao {
    private StatementProvider statementProvider;
    // Constructor and other methods ommitted
    public void InsertPersonalData(PersonalData personaldata) throws SQLException, DAOException, ClassNotFoundException {
        try {
            PreparedStatement psmt = statementProvider.createInsertStatementForPersonalData(); 
            psmt.setString(1, personaldata.getiD());
            psmt.setString(2, personaldata.getPatientName());
            psmt.setString(3, personaldata.getBirthDate());
            psmt.setString(4, personaldata.getPlaceOfBirth());
            psmt.setString(5, personaldata.getGender());
            psmt.setString(6, personaldata.getNationality());
            psmt.setString(7, personaldata.getCurrentAddress());
            psmt.setString(8, personaldata.getCityAddress());
            psmt.setString(9, personaldata.getMaritalStatus());
            psmt.setString(10, personaldata.getOffspring());
            psmt.setString(11, personaldata.getAgeOfYoungestOffspring());
            psmt.setString(12, personaldata.getWorkNature());
            psmt.setString(13, personaldata.getPhoneNumber());
            psmt.setString(14, personaldata.geteMail());

            psmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);

        }
    } 
}