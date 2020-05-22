public class Servidor {
   public static void main(String[] args) throws IOException {
     ServerSocket servidor = new ServerSocket(12345);
     System.out.println("Port 12345 open!");

     Socket cliente = servidor.accept();
     System.out.println("new client connection " +   
       cliente.getInetAddress().getHostAddress()
     );

     Scanner s = new Scanner(cliente.getInputStream());
     while (s.hasNextLine()) {
       System.out.println(s.nextLine());
     }

     s.close();
     servidor.close();
     cliente.close();
   }
 }