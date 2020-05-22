@FXML
void initialize(){
     assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
     colUserName.setCellValueFactory(
        new PropertyValueFactory<Usermaster,String>("userName"));        
    colPassword.setCellValueFactory(                
        new PropertyValueFactory<Usermaster,String>("userPassword"));
    colUserType.setCellValueFactory(
        new PropertyValueFactory<Usermaster,String>("userType"));        
    colPhoto.setCellValueFactory(
        new PropertyValueFactory<Object,ImageView>("userPhoto"));
    objDbClass = new DBClass();
    try{
        con = objDbClass.getConnection();
        buildData();
    }
    catch(ClassNotFoundException ce){
        logger.info(ce.toString());
    }
    catch(SQLException ce){
        logger.info(ce.toString());
    }
}

private ObservableList<Usermaster> data;

public void buildData(){        
    data = FXCollections.observableArrayList();
    try{      
        String SQL = "Select * from usermaster Order By UserName";            
        ResultSet rs = con.createStatement().executeQuery(SQL);  
        while(rs.next()){
            Usermaster cm = new Usermaster();
            cm.userId.set(rs.getInt("UserId"));                       
            Image img = new Image("tailoring/UserPhoto/User"+cm.getUserId().toString()+".jpg");                

            ImageView mv = new ImageView();
            mv.setImage(img);
            mv.setFitWidth(70);
            mv.setFitHeight(80);
            cm.userPhoto.set(mv);
            cm.userName.set(rs.getString("UserName"));
            cm.userPassword.set(rs.getString("UserPassword"));
            cm.userType.set(rs.getString("UserType"));
            data.add(cm);                  
        }
        tableview.setItems(data);
    }
    catch(Exception e){
          e.printStackTrace();
          System.out.println("Error on Building Data");            
    }
}