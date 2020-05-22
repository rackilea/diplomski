String sql = "INSERT INTO hospital (PNA, Patient_Name, Age, Gender, Department, Doctor) VALUES (?, ?, ?, ?, ?, ?)";

PreparedStatement stmt = connection.prepareStatement(sql);

stmt.setString( 1, z );
stmt.setString( 2, w );
stmt.setInt( 3, m );
...
stmt.executeUpdate();