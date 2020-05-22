import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.bouncycastle.util.io.pem.PemReader;
import org.castor.util.Base64Decoder;

import fr.paris.lutece.portal.service.util.AppLogService;


/**
 * Classe d'aide à l'interfacage avec le service paybox.
 *
 * Toutes les informations parameterables sont sous la forme paybox.*
 */
public final class PayboxUtil
{

    /** The Constant CHARSET. */
    private static final String CHARSET = "utf-8";

    /** The Constant ENCRYPTION_ALGORITHM. */
    private static final String ENCRYPTION_ALGORITHM = "RSA";

    /** The Constant HASH_ENCRIPTION_ALGORITHM. */
    private static final String HASH_ENCRYPTION_ALGORITHM = "SHA1withRSA";

    /**
     * constructeur privé pour classe statique.
     */
    private PayboxUtil(  )
    {
    }

    /**
     * Controle si une signature est bien celle du message à l'aide de la clé
     * publique de l'emmeteur?.
     *
     * @param message le message
     * @param sign la signature
     * @param keyPath le chemin vers la clé publique.
     * @return true si la signature est bien celle du message avec la clé privé
     *         attendue.
     */
    public static boolean checkSign( String message, String sign, String keyPath )
    {
        boolean ret = false;

        try
        {
            ret = PayboxUtil.verify( message, sign, PayboxUtil.getKey( keyPath ) );
        }
        catch ( final FileNotFoundException e )
        {
            AppLogService.error( e );
        }
        catch ( final IOException e )
        {
            AppLogService.error( e );
        }
        catch ( final NoSuchAlgorithmException e )
        {
            AppLogService.error( e );
        }
        catch ( final InvalidKeySpecException e )
        {
            AppLogService.error( e );
        }
        catch ( final InvalidKeyException e )
        {
            AppLogService.error( e );
        }
        catch ( final SignatureException e )
        {
            AppLogService.error( e );
        }

        return ret;
    }


    /**
     * Récupère la clé publique à partir du chemin passé en paramètre.
     *
     * @param keyPath le chemin vers la clé.
     * @return la clé publique
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InvalidKeySpecException the invalid key spec exception
     */
    private static PublicKey getKey( String keyPath )
        throws NoSuchAlgorithmException, IOException, InvalidKeySpecException
    {
        final KeyFactory keyFactory = KeyFactory.getInstance( PayboxUtil.ENCRYPTION_ALGORITHM );
        final PemReader reader = new PemReader( new FileReader( keyPath ) );
        final byte[] pubKey = reader.readPemObject(  ).getContent(  );
        final X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec( pubKey );

        return keyFactory.generatePublic( publicKeySpec );
    }

    /**
     * effectue la vérification du message en fonction de la signature et de la
     * clé.
     *
     * @param message le message
     * @param sign la signature
     * @param publicKey la clé publique.
     * @return true, if successful
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws InvalidKeyException the invalid key exception
     * @throws SignatureException the signature exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    private static boolean verify( String message, String sign, PublicKey publicKey )
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException
    {
        final Signature sig = Signature.getInstance( PayboxUtil.HASH_ENCRYPTION_ALGORITHM );
        sig.initVerify( publicKey );
        sig.update( message.getBytes( PayboxUtil.CHARSET ) );

        final byte[] bytes = Base64Decoder.decode( URLDecoder.decode( sign, PayboxUtil.CHARSET ) );

        return sig.verify( bytes );
    }
}