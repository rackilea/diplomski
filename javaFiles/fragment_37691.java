// Array of values to be passed in query
        String[] values;

        // Construct the query string first
        StringBuilder stringBuilder = new StringBuilder(
                "select cola from tableA where val in(");

        for (int i = 0; i < values.length; i++) {
            if (i + 1 == values.length) {
                stringBuilder.append("?)");
            } else {
                stringBuilder.append("?,");
            }
        }

        pstmt = connection.prepareStatement(stringBuilder.toString());
        int i = 0;
        for (String value : values) {
            pstmt.setString(i++, value);
        }

        rs = pstmt.executeQuery();