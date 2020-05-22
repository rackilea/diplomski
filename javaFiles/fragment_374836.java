public void Login (ActionEvent event) {
        try {
            if(loginModel.isLogin(comboType.getValue(), 
                 txtUsername.getText(), txtPassword.getText())) {
                //add your code
            }
            else {
                isConnected.setText(" pass is not correct");
            }
        } catch (TypeNotFoundException ex) {
            isConnected.setText("Type is not correct");  
            //add your logger      
     } catch (UserNameNotFoundException ex) {
         isConnected.setText("Username is not correct");  
          //add your logger
        } catch (SQLException ex) {
           isConnected.setText("technical problem,please try after some time");  
           //add your logger
        } catch (IOException ex) {
          //add your logger
        }
    }