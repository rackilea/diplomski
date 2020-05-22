PreparedStatement st = null;
    ResultSet rec = null;

    SprayJobItem item = null;

    try {

        st = conn.prepareStatement("select * from sprayjob where headerref=? and jobname=?");
        st.setString(1, request.getParameter("joblistref"));
        st.setString(2, request.getParameter("jobname"));

        rec = st.executeQuery();
        if (rec.next()) {
            item = new SprayJobItem(rec);
        }

    } catch (SQLException ex) {
        // handle any errors
        ReportError.errorReport("SQLException: " + ex.getMessage());
        ReportError.errorReport("SQLState: " + ex.getSQLState());
        ReportError.errorReport("VendorError: " + ex.getErrorCode());

    } catch (Exception ex) {
        ReportError.errorReport("Error: " + ex.getMessage());
    } finally {
        // Always make sure result sets and statements are closed,
        if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) {
            ;
        }
        ps = null;
    }
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            ;
        }
        rs = null;
    }
    }