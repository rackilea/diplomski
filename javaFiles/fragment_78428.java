public static void main(String[] args) throws IOException, SQLException {

PreparedStatement preparedstatement = null;


try{
    String read=null;
    in = new BufferedReader(new FileReader("patientlist.txt")); 
    while ((read = in.readLine()) != null) {
        String[] splited = read.split("\\s+");
        name=splited[0];
        age=splited[1];
        height=splited[2];
        weight=splited[3];      
        addpatient(connection, preparedstatement, name, age, height, weight);
    }

}
catch (IOException e) {System.out.println("There was a problem: " + e);}
    if (connection != null)
    try{connection.close();} catch(SQLException ignore){} 
}


public static void addpatient(Connection connection, PreparedStatement preparedstatement, String name, String age, String height, String weight) throws SQLException{
preparedstatement=connection.prepareStatement("insert into allpatients(name, age, height, weight) values(?,?,?,?)");
preparedstatement.setString(1, name);
preparedstatement.setString(2, age);
preparedstatement.setString(3, height);
preparedstatement.setString(4, weight);
preparedstatement.executeUpdate();


}