Statement st = con.createStatement();
        List<String[]> systems = new ArrayList<String[]>();
        String item = "SELECT ram, cpu, mainboard, cases, gfx FROM computer_system";
        ResultSet rs = st.executeQuery(item);
        while (rs.next()){
            String[] row = new String[5];
            row[0] = rs.getString("ram");
            row[1] = rs.getString("cpu");
            row[2] = rs.getString("mainboard");
            row[3] = rs.getString("cases");
            row[4] = rs.getString("gfx");
            systems.add(row);
        }