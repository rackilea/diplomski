public final class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) {
        User user = new User();
        // get other columns here
        EnumSet<User_Authority> granted = EnumSet.noneOf(User_Authority.class);
        for (User_Authority auth : User_Authority.values())
            if (rs.getInt(auth.getColumnName()) == 1)
                granted.add(auth);
        user.setAuthorities(granted);
        return user;
    }
}