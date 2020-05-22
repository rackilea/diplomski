Query query=session.createQuery("insert into BackupOTP (otpId, createdTime, encryptedOTP, isExpired, updatedTime)"
+ " select otpId, createdTime, encryptedOTP, isExpired, updatedTime from OTP where isExpired=:boolean");

query.setBoolean("boolean", true);
int i=query.executeUpdate();
System.err.println("i = "+i);