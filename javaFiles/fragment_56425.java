psmt = con.prepareStatement("insert into mm values (?, AES_ENCRYPT(?, ?), AES_ENCRYPT(?, ?))");
psmt.setInt(1, id);
psmt.setString(2, name);
psmt.setBytes(3, key);
psmt.setstring(4, sal);
psmt.setBytes(5, key);