//(assuming you have a ResultSet named RS)
PreparedStatement psMySql = connMySql.prepareStatement("select myBlob from myTable where ...");
Blob blob = rs.getBlob("myBlob");

int blobLength = (int) blob.length();  
byte[] blobAsBytes = blob.getBytes(1, blobLength);

PreparedStatement psPostresql = connPostgresql.prepareStatement("INSERT INTO myNewTable VALUES (?, ?)");
psPostresql.setString(1, myId);
psPostresql.setBytes(2, blobAsBytes);
psPostresql.executeUpdate();

//release the blob and free up memory.
blob.free();