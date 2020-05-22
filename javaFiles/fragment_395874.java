// add this import
import com.google.common.net.InetAddresses;


    // add this if-statement surrounding the domain name parsing
    // if it isn't an IP address
    if (!InetAddresses.isInetAddress(domain)) {
        // strip off subdomains, leaving the top level domain only
        InternetDomainName domainName = InternetDomainName.from(domain);
        if (domainName.isUnderPublicSuffix() && !domainName.isTopPrivateDomain()) {
            // preserve leading dot
            return "." + domainName.topPrivateDomain().toString();
        }
    }