finally {

        if (resultset != null) {
            resultset.close();
        }

        if (s != null) {
            s.close();
        }

        if (con != null) {
            con.close();
        }

    }