public void callMyProc(SomeEntity someEntity) {
        Connection connection = null;

        try {
            connection = getConnection();
            CallableStatement cstmt = connection.prepareCall("{call dbo.my_procedure(?)}");
            cstmt.setLong(1, someEntity.getId());
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }