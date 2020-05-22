public static Map<Integer, String[]> formXPath(int formid) {
    Map<Integer, String[]> form = new HashMap<>();
    int form_id = -1;
    Statement s3 = null;
    String[] form_dtl;
    try {
        s3 = con.createStatement();

        String query = "SELECT form_id,form_link,form_name FROM form_details where base_mainid = " + formid;

        ResultSet rs2 = s3.executeQuery(query);
        while (rs2.next()) {
            // instanciate here
            form_dtl = new String[2];

            form_id = rs2.getInt(1);
            form_dtl[0] = rs2.getString(2);
            form_dtl[1] = rs2.getString(3);
            form.put(form_id, form_dtl);
        } 

    } catch(Exception e) { /* Handle exception here */ }

    return form;
}