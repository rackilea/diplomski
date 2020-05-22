if (index < 12){
    index++;  
    user[index]=txtUsername.getText();
    pas[index]=Password.getText();

    AlertBox.display("Account information","Your account has been succesfully created: \n Username: " + user[index] + " \n Pasword: " + pas[index]  );
    txtUsername.clear();
    Password.clear();
}