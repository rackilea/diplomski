psmnt = conn.prepareStatement("INSERT INTO upload_data(user_id,photo,audio) "
                        + "values(?,?,?)");

fisAudio =  new FileInputStream(audioFile);
// you should bind something to the first and second ? marks too!
psmnt.setLong(1, 12345L);
psmnt.setString(2, "this is my photo");
psmnt.setBinaryStream(3, (InputStream) fisAudio, (int) (audioFile.length()));
int s = psmnt.executeUpdate();