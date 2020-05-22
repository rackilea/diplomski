//first you "prepare" your statement (where the '?' acts as a kind of placeholder)
PreparedStatement st = con.prepareStatement("insert into user (user,age,school,password) values (?,?,?,?);");
//now you bind the data to your parameters
st.setString(1, user);
...
//and then you can execute it
st.executeUpdate()