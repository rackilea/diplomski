public class Main {

public static void main(String args[]) {
    byte[] key = new byte[64];
    new SecureRandom().nextBytes(key);
    Date date = new Date();
    long t = date.getTime();
    Date expirationTime = new Date(t + 5000l); // set 5 seconds

    String compact = Jwts.builder().setSubject("Joe").setExpiration(expirationTime).signWith(SignatureAlgorithm.HS256, key).compact();
    System.out.println("compact : " + compact);
    try {
        String unpack = Jwts.parser().setSigningKey(key).parseClaimsJws(compact).getBody().getSubject();
        System.out.println("unpackage 0 : " + unpack);

        // check if the expiration work.
        Thread.sleep(3000);
        System.out.println("unpackage 1 : " + Jwts.parser().setSigningKey(key).parseClaimsJws(compact).getBody().getSubject());

        //Create a *new* token that reflects a longer extended expiration time.
        Date date1 = new Date();
        long t1 = date1.getTime();
        Date expirationTime1 = new Date(t1 + 5000l); //prolongation 5 seconds

        String compact2 = Jwts.builder().setSubject("Joe").setExpiration(expirationTime1).signWith(SignatureAlgorithm.HS256, key).compact();

        // check if the extend expiration work.
        Thread.sleep(3000);
        System.out.println("unpackage 2 : " + Jwts.parser().setSigningKey(key).parseClaimsJws(compact2).getBody().getSubject());

        Thread.sleep(1000);
    } catch (InterruptedException | ExpiredJwtException ex) {
        System.out.println("exception : " + ex.getMessage());
        Thread.currentThread().interrupt();
    }
}
}