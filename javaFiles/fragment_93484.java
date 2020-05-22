public class Server {

  public static void main(String[] args) throws IOException {


    String hostName = "localhost";
    int portNumber = 10004;

    try (

        //open a socket
        Socket clientSocket = new Socket(hostName, portNumber);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


    ) {

      System.out.println("Connected");
      Double[][] test2 = new Double[5][2];
      test2[1][1] = 0.1;
      test2[1][0] = 0.2;
      test2[2][1] = 0.2;
      test2[2][0] = 0.2;
      test2[3][1] = 0.1;
      test2[3][0] = 0.2;
      test2[4][1] = 0.2;
      test2[4][0] = 0.2;
      test2[0][1] = 0.2;
      test2[0][0] = 0.2;


      System.out.println("A");
      out.println(new JSONArray(test2).toString());
      System.out.println("B");


      long t = System.currentTimeMillis();
      long end = t + 15000;


      while (System.currentTimeMillis() < end) {
        String response;
        while ((response = in.readLine()) != null) {
          System.out.println("receiving");
          System.out.println( response );

        }
      }
      //listen for input continuously?
      //clientSocket.close();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }
}