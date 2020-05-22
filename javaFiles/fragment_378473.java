import java.security.cert.X509Certificate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

@Named
public class UsernameService {

    private static final String MISSING_NAME = null;

    private static final Logger LOG = Logger.getLogger(UsernameService.class.getCanonicalName());

    @Inject
    private final Optional<X509Certificate> cert = null;

    public String currentRequestUsername() {
        if (cert.isPresent()) {
            try {
                LOG.finest("Check Certificate: " + cert);
                for (Rdn rdn : new LdapName(cert.get().getSubjectDN().getName()).getRdns()) {
                    LOG.finest("Check RDN entry for Common name(cn): " + rdn);
                    if (rdn.getType().equals("CN")) {
                        LOG.finer("Found Username: " + rdn.getValue().toString());
                        return rdn.getValue().toString();
                    }
                }
            } catch (InvalidNameException e) {
                LOG.log(Level.CONFIG, "Parse DName impossible: " + cert.get().getSubjectDN().getName() + ".", e);
            } catch (NullPointerException e) {
                LOG.log(Level.FINE, e.getMessage(), e);
            } catch (RuntimeException e) {
                LOG.log(Level.FINE, e.getMessage(), e);
            }
        }
        return MISSING_NAME;
    }
}