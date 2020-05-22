for (int i = 0; i < minSize; i++) {
    preparedStmt.setString(1, pars.getListId().get(i));
    preparedStmt.setString(2, pars.getTitleId().get(i));
    preparedStmt.setString(3, pars.getAboutAr().get(i));
    preparedStmt.executeUpdate();
}