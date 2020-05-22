try (PreparedStatement preparedStatement = conn.prepareStatement(removeFollowersStmt)) {
        preparedStatement.setLong(1, Long.parseLong(conversation) );
        preparedStatement.setLong(2, Long.parseLong(userId) );
        preparedStatement.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }