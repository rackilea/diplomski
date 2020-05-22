byte[] password = p.getBytes("UTF-8");
byte[] attempt = a.getBytes("UTF-8");

passwordHash = DigestUtils.md5(password);
attemptHash = DigestUtils.md5(attempt);

System.out.println(new String(passwordHash));
System.out.println(new String(attemptHash));