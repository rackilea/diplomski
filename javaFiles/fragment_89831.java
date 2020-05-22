try {
    DataSource dataSource = (DataSource) getServletContext().getAttribute("dataSource");
    validUserCount = new MasterDao(dataSource).getValidUserCount(user);
} catch (SQLException sqle) {
    LOG.error("Exception while validating user credentials for user with username: " +
            user.getUsername() + " and pwd:" + user.getPwd(), sqle);
}