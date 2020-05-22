// Check that such a logic exists
if (rs.next()) {
    email = rs.getString("email");
}

// for good measures, just double check there isn't more than one 
// of these logins:
if (rs.next()) {
    throw new Exception ("This cannot be!"); // Or something more sensible
}