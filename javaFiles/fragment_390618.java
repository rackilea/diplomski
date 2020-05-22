public class Trial {

  public static void main(String[] args) {

            Bloblo t = new Bloblo(2345);
            Blabla ts = new Blabla("Imad", t);
            ts.run();
          }
}

public class Bloblo {
        private int port;
        public Bloblo(int leport)
        {
            port = leport;
            System.out.println("au debut le port est: " + port);
        }
        public void afficher(String nom)
        {
            System.out.println("on va afficher dans BLOBLO: " + nom + "\net le port est: "+ port);

        }
}

public class Blabla implements Runnable{

        String Name = "";
        Bloblo bloblo;
        public Blabla(String nom, Bloblo b)
        {
            Name = nom;
            bloblo = b;
        }

        public void run()
        {
            System.out.println("voici le nom: " + Name);

            bloblo.afficher(Name);
        }
 }