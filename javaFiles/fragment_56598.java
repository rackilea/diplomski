int carMakesSelectedIndex = comboCarMakes.getSelectedIndex();    
int carModelsSelectedIndex = comboCarModels.getSelectedIndex();
PreparedStatement stmt=con.prepareStatement("insert into car_attributes values(?,?,?,?,?,?,?,?,?,?)");  
stmt.setInt(1,carAttribute); 
stmt.setInt(2,carMakesIdList.get( carMakesSelectedIndex  ) ); 
stmt.setInt(3,carMakesIdList.get( carModelsSelectedIndex ) ); 
stmt.setString(4,carYear );
// the same with other attribute