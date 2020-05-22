public class Client {

    public void send(String file_name){
        try {
            Socket socket = new Socket("IBM-PC", 3332);
            File file = new File(file_name);
            System.out.println(file_name);
            ObjectInputStream ois = new ObjectInputStream(
                    socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream());
            oos.writeObject(file.getName());
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[Server.BUFFER_SIZE];
            Integer bytesRead = 0;
            while ((bytesRead = fis.read(buffer)) > 0) {
                oos.writeObject(bytesRead);
                oos.writeObject(Arrays.copyOf(buffer, buffer.length));
            }
            ois = null;
            oos = null;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Client c = new Client();
        c.send("D://1.jpg");         // first image path
        c.send("D://0.jpg");        //  second image path
    }   
}