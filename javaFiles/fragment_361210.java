//Solved the issue by surrounding the if Statement by while loop
try {
            String sql = "SET ROLE HIVP_WRITE";
            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                if (result.next()) {
                    out.println("ROLE SUCCESSFULLY SET");
                } else {
                    out.println("ROLE IS NOT SET");
                }
            }
        } catch (Exception e) {
            out.println("ERROR WHILE SETTING ROLE: " + e);
        }