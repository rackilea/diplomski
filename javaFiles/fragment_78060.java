process = Runtime.getRuntime().exec("su");
outputStream = new DataOutputStream(process.getOutputStream());
outputStream.writeBytes("echo DONE\n");
outputStream.flush();
inputStream = new DataInputStream(process.getInputStream());
byte[] buff = new byte[4];
inputStream.read(buff);
if(new String(buff).equals("DONE"));
     MainActivity.rootLatch.countDown();