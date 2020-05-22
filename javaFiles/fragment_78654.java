StringBuilder param = new StringBuilder();
        if (a != null) {
            for (String str : a) {
                param.append("'").append(str).append("', ");
            }
        }
        StringBuilder param1 = new StringBuilder();
        if (b != null) {
            for (String str : b) {
                param1.append("'").append(str).append("', ");
            }
        }

        String prm = param.toString().length() > 2 ? param.toString()
                .substring(0, param.toString().length() - 2) : null;
        String prm1 = param1.toString().length() > 2 ? param1.toString()
                .substring(0, param1.toString().length() - 2) : null;

        String query = "select  * from products where ";

        if (prm != null && prm1 != null) {
            query += "Brand in (" + prm + ") or Flavour in (" + prm1 + ")";
        } else if (prm != null && prm1 == null) {
            query += "Brand in (" + prm + ")";
        } else if (prm1 != null && prm == null) {
            query += "Flavour in (" + prm1 + ")";
        }