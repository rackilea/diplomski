public ArrayList<Car> getAllCar() {
    ArrayList<Car> AllCar = new ArrayList<Car>();
    try {
           //add your existing code here

            Car nextCar = new Car(resultSet.getString("ID"), ,
               resultSet.getString("cLicense"), 
               resultSet.getInt("cJourneys"),
               resultSet.getString("cUsername"),
               resultSet.getString("cPassword").toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
       //add null checks and close the resources
       statement.close();
       conn.close();
       resultSet.close();
    }
    return AllCar;
}