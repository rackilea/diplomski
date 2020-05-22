if (rset.next()) { 
    String lastName = rset.getString(1); 
    String mi = rset.getString(2); 
    String firstName = rset.getString(3); 
    String title = rset.getString(4); 
    String grade = rset.getString(5); 

    lblStatus.setText(firstName + " " + mi + 
    " " + lastName + "'s grade on course " + title + " is " + 
    grade); 
} else { 
    lblStatus.setText("Not found"); 
}