import com.google.common.net.InternetDomainName;

public class splitDomain {


    public static void main(String[] args) {

            // Split URL into protocol, domain, port and URI
            // here i am just extracting .com, .net, co.in letter on you can subtract this from your url and u will get exact url
          InternetDomainName it = InternetDomainName.from("www.vinay.com");
          System.out.println(it.publicSuffix().name());

          it = InternetDomainName.from("www.vinay.co.in");
          System.out.println(it.publicSuffix().name());

          it = InternetDomainName.from("www.vinay.co.uk");
          System.out.println(it.publicSuffix().name());

          //for subdomain
          String url = "firstsubdomain.developer.vinay.co.in";
          url = InternetDomainName.from(url).topPrivateDomain().name();
          it = InternetDomainName.from(url);
          String domainname = it.publicSuffix().name();
          System.out.println(domainname);
          String temp = url.replaceAll("."+domainname, "");
          System.out.println(temp);

    }



}