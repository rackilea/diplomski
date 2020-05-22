session.setConfig(conf);
// with a Properties that includes
conf.put("kex","ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group1-sha1");
// or if you prefer just 
conf.put("kex","diffie-hellman-group1-sha1");
// since server doesn't agree to any ecdh anyway