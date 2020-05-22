public List<BDto> getBoardList(int startRow, int endRow, String keyField, String keyWord) {

    List<BDto> dtos = new ArrayList<BDto>();

    // the %s in the template will be replaced with a 
    // WHERE condition when a keyword is present
    final String sqlTemplate = "select rn, bId, bName, bTitle, "
            + "bContent, bDate, bHit, bGroup, bStep, bIndent "
            + "from ( "
            + "     select b.*, row_number() over (order by bGroup DESC, bStep asc) rn" 
            + "    from mvc_board b %s "
            + "    ) "
            + "    where rn between ? and ? "
            + "order by rn";

    boolean whereCondition = false;

    String sql = null;

    if (keyWord != null && !keyWord.equals("") && !keyWord.equals("null")) {
        sql = String.format(sqlTemplate, 
                   " WHERE " + keyField.trim() + " LIKE '%' || ? || '%'");
        whereCondition = true;
    } else {
        sql = String.format(sqlTemplate, "");
    }

    System.out.println(sql);

    try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        int parameterIndex = 1;

        if (whereCondition) {
            preparedStatement.setString(parameterIndex++, keyWord);
        }
        preparedStatement.setInt(parameterIndex++, startRow);
        preparedStatement.setInt(parameterIndex, endRow);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            int count = 0;

            while (resultSet.next()) {

                int ROWNUM = resultSet.getInt("rn");
                int bId = resultSet.getInt("bId");
                String bName = resultSet.getString("bName");
                String bTitle = resultSet.getString("bTitle");
                String bContent = resultSet.getString("bContent");
                Timestamp bDate = resultSet.getTimestamp("bDate");
                int bHit = resultSet.getInt("bHit");
                int bGroup = resultSet.getInt("bGroup");
                int bStep = resultSet.getInt("bStep");
                int bIndent = resultSet.getInt("bIndent");

                dtos.add(new BDto(ROWNUM, bId, bName, bTitle, 
                        bContent, bDate, bHit, bGroup, bStep, bIndent));

                count++;
            }
            System.out.println(count);
        }

    } catch (SQLException e) {
        System.out.println(e + "=> getBoardList fail");
    }

    return dtos;
}