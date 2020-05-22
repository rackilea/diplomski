import org.conscrypt.Conscrypt;
import java.security.Security;
...

// Somewhere in main()
Security.insertProviderAt(Conscrypt.newProvider(), 1);