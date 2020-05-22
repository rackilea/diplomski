StringBuilder s = new StringBuilder();
int c = 0;
while (rset.next()) { 
    String lastName = rset.getString(1); 
    String mi = rset.getString(2); 
    String firstName = rset.getString(3); 
    String title = rset.getString(4); 
    String grade = rset.getString(5); 
    s.append(firstName).append(" ").append(mi).append(" ").append(lastName).append("'s grade on course ").append(title).append(" is ").append(grade).append("\n");     
    c++;
}
if(c>0) {
    lblStatus.setText(s.toString());
} else {
    lblStatus.setText("Not found");
}