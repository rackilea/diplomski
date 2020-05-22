URLConnection connection = new URL("http://localhost:8080/servertest/Server").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Content-Type", "application/octet-stream");

ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
oos.writeObject(c2);
oos.close();

ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
boolean readBoolean = ois.readBoolean();
ois.close();

System.out.println(readBoolean);