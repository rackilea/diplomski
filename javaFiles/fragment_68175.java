int index = existCheck(userId, title);
if(index > 0){
      st.executeUpdate("INSERT INTO memories (userid, title, description) VALUES ('"+userId+"', '"+title+index+"', '"+desc+"')");
} else{
      st.executeUpdate("INSERT INTO memories (userid, title, description) VALUES ('"+userId+"', '"+title+"', '"+desc+"')");    
}