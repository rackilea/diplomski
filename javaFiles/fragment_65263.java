PreparedStatement ps = conn.prepareStatement(query);
// no set parameters
ps.setInt(1, someDTO.getId());
ps.setString(2, someDTO.getUserName());
ps.setString(3, someDTO.getPassword());
ps.setString(4, someDTO.getFirstName());
ps.setString(5, someDTO.getLastName());
ps.executeUpdate();
System.out.println("Data was inserted successfully.");
return true;