String inputPassword= **String.valueOf(passwordFld);**
    String inputUsername= username.getText();

    for(int i=0; i < passworddatabase.size(); i++) 
    {
     if (passworddatabase.get(i).contains(inputPassword))
    {