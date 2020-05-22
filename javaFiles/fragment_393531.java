import com.google.gson.Gson;
  import java.io.BufferedReader;
  import java.io.InputStreamReader;
  import java.net.URL;
  import java.net.URLConnection;

  public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.google.com/ig/calculator?hl=en&q=1USD%3D%3FCAD");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            yc.getInputStream()));
        String jsonObject = "";
        String line;
        while ((line = in.readLine()) != null) 
            jsonObject += line;

        in.close();
        System.out.println(jsonObject);
        Gson gson = new Gson();
        GoogleCurrency another = gson.fromJson(jsonObject, GoogleCurrency.class);
        another.print();
    }

  }


  public class GoogleCurrency {
     private String lhs;
     private String rhs;
     private String error;
     private String icc;

   public GoogleCurrency() {
    lhs = "0 U.S Dollar";
    rhs = "0 U.S Dollar";
    error = "true";
    icc = "false";
   }

   public GoogleCurrency(String lhs,String rhs,String error,String icc) {
    this.lhs = lhs;
    this.rhs = rhs;
    this.error = error;
    this.icc = icc;
   }

   public void print() {
    System.out.println(lhs + " = " + rhs);
   }
 }