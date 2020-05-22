pstmt = conn.prepareStatement(Query, Statement.RETURN_GENERATED_KEYS);  
pstmt.executeUpdate();  
ResultSet keys = pstmt.getGeneratedKeys();  
keys.next();  
key = keys.getInt(1);  // gets the last inserted id
keys.close();  
pstmt.close();  
conn.close();  
} catch (Exception e) { e.printStackTrace(); }  
return key;  
}