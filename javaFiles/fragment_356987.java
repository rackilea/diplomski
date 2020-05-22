private <T extends ValidateVO> List<T> getValidateSubclassByType(Class<T> clazz, String type) {
    List<T> validates = new ArrayList<>();

    StringBuilder bldValidates = new StringBuilder()
            .append("SELECT VALIDATE_ID, VALIDATE_DESCRIPTION, VALIDATE_ACTIVE ")
            .append("FROM tblVALIDATE WHERE VALIDATE_TYPE = ?");

    try (Connection con = dataSource.getConnection();
            PreparedStatement pstmtValidates = con.prepareStatement(bldValidates.toString());) {
        pstmtValidates.setString(1, type);
        ResultSet rsWholesalerGroups = pstmtValidates.executeQuery();
        if (rsWholesalerGroups.isBeforeFirst()) {
            while (rsWholesalerGroups.next()) {
                T validate = clazz.newInstance();
                validate.setId(rsWholesalerGroups.getInt("VALIDATE_ID"));
                validate.setName(rsWholesalerGroups.getString("VALIDATE_DESCRIPTION"));
                validate.setActive(rsWholesalerGroups.getString("VALIDATE_ACTIVE").equals("Y"));
                validates.add(validate);
            }
        } else {
            System.out.println("No WHOLESALERS");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return validates;
}