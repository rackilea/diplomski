public static void fetchIthos(ArrayList<String> ithosList, UserDto user) {
    // TODO Auto-generated method stub
    int i = 1;
    //get our stuff first - raw materials and doc names and paths
    try {

        Connection conn = user.getConnection();
        Statement st = conn.createStatement();
        ResultSet rsCount = st.executeQuery("SELECT COUNT(*) from raw_material");
        rsCount.first();
        long r = (Long) rsCount.getObject(i);

        for (i=1; i < r+1; i++) {

            ResultSet rs = st.executeQuery("SELECT * FROM raw_material where object_id =" + i + "");

            //moves to the first record
            rs.first();

            do {
                String result = rs.getString("raw_material_number");
                System.out.println("next item: " + result);
                ithosList.add(rs.getString("raw_material_number"));
            } while(rs.next());
        }
    }

    catch (Exception e) {
        ithosList.equals(null);
        System.out.println("DB error : " + e);
    }

}