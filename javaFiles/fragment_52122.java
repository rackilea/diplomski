PreparedStatement st = conn.prepareStatement("insert into login (brugernavn, kodeord, status, created_time, last_login_time) values (?,?, ?, ?, ?)");
st.setString(1, username);
st.setString(2, password);
st.setBoolean(3, true);
st.setObject(4, createdTime);
st.setObject(5, lastLoginTime);
st.executeUpdate();
st.close();