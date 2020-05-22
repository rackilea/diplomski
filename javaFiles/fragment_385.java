String input = "Company comp1 and comp2";

    String data = input.substring(8, input.length());
    String [] companies = data.split("\\b and \\b");

    String sql = "SELECT * FROM CompanyData WHERE ID IN (SELECT ID FROM CompanyDomain WHERE companyName IN (";

    for(int i = 0; i < companies.length - 1; i++) {
        sql += "?,"
    }

    sql += "?)";

    for(int i = 0; i < companies.length; i++) {
        // Use prepared statement and insert the values here
    }