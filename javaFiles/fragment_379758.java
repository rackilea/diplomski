/* Alternatively, use this for non-PreparedStatements:
try (Statement s = cn.createStatement()) {
    Boolean result = s.execute(sql); */
try (PreparedStatement s = cn.prepareStatement(sql)) {
    // Use good old three-valued boolean logic
    Boolean result = s.execute();

    fetchLoop:
    for (int i = 0;; i++) {

        // Check for more results if not already done in this iteration
        if (i > 0 && result == null)
            result = s.getMoreResults();
        System.out.println(result);

        if (result) {
            result = null;

            try (ResultSet rs = s.getResultSet()) {
                System.out.println("Fetching result " + i);
            }
            catch (SQLException e) {
                // Ignore ORA-17283: No resultset available
                if (e.getErrorCode() == 17283)
                    continue fetchLoop;
                else
                    throw e;
            }
        }
        else if (s.getUpdateCount() == -1)
            // Ignore -1 value if there is one more result!
            if (result = s.getMoreResults())
                continue fetchLoop;
            else
                break fetchLoop;
    }
}