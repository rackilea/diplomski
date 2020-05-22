import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class Test
{

    // add more system packages here
    private static final String[] SYSTEM_PACKAGES = new String[] {
        "java.",
        "javax.",
        "android."
    };

    public static void main( String[] args )
    {
        Exception e = new Exception();
        HashCode eh = hashApplicationException( e );
        System.out.println( eh.toString() );
    }

    private static HashCode hashApplicationException( Throwable exception )
    {
        Hasher md5 = Hashing.md5().newHasher();
        hashApplicationException( exception, md5 );
        return md5.hash();
    }

    private static void hashApplicationException( Throwable exception, Hasher hasher )
    {
        for( StackTraceElement stackFrame : exception.getStackTrace() ) {
            if( isSystemPackage( stackFrame ) ) {
                continue;
            }

            hasher.putString( stackFrame.getClassName(), Charsets.UTF_8 );
            hasher.putString( ":", Charsets.UTF_8 );
            hasher.putString( stackFrame.getMethodName(), Charsets.UTF_8 );
            hasher.putString( ":", Charsets.UTF_8 );
            hasher.putInt( stackFrame.getLineNumber() );
        }
        if( exception.getCause() != null ) {
            hasher.putString( "...", Charsets.UTF_8 );
            hashApplicationException( exception.getCause(), hasher );
        }
    }

    private static boolean isSystemPackage( StackTraceElement stackFrame )
    {
        for( String ignored : SYSTEM_PACKAGES ) {
            if( stackFrame.getClassName().startsWith( ignored ) ) {
                return true;
            }
        }

        return false;
    }
}