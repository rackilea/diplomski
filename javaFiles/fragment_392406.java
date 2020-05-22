int tokens = 0;

try {
    result = statement.executeQuery();
    result.next();
    tokens = result.getInt(1);
} catch (SQLException e) {
    e.printStackTrace();
}

int newToken = tokens + amnt;