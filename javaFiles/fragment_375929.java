import java.util.ArrayList;
import java.util.List;


public final class HumongousInt {
public static HumongousInt of( String string ) {
    return new HumongousInt( asByteArray( string ) );
}

private static byte[] asByteArray( String string ) {
    int length = string.length();
    byte[] data = new byte[ length ];
    for( int i = 0; i < length; i++ ) {
        data[ i ] = asByte( string.charAt( i ) );
    }
    return data;
}

private static byte asByte( char c ) {
    if( c > '9' && c < '0' ) {
        throw new IllegalArgumentException( "Wrong numbe format only numbers 0-9 could be present" );
    }
    return ( byte ) ( c - '0' );
}

private final byte[] digits;

private HumongousInt( byte[] digits ) {
    this.digits = digits;
}

public HumongousInt add( HumongousInt other ) {
    int maxLength = Math.max( this.digits.length, other.digits.length );
    ArrayList< Byte > data = new ArrayList<>();
    int overhead = 0;
    int i = 1;
    while( overhead > 0 || ( i <= maxLength ) ) {
        int currentDigit = overhead;
        int thisIndex = ( this.digits.length - i );
        if( thisIndex >= 0 ) {
            currentDigit += this.digits[ thisIndex ];
        }
        int otherIndex = ( other.digits.length - i );
        if( otherIndex >= 0 ) {
            currentDigit += other.digits[ otherIndex ];
        }
        overhead = currentDigit / 10;
        data.add( Byte.valueOf( ( byte ) ( currentDigit %= 10 ) ) );
        i++;
    }
    return new HumongousInt( asInvertedByteArray( data ) );
}

private byte[] asInvertedByteArray( List< Byte > list ) {
    byte[] data = new byte[ list.size() ];
    for( int i = data.length - 1, j = 0; i >= 0; i--, j++ ) {
        data[ j ] = list.get( i );
    }
    return data;
}

public HumongousInt add( int i ) {
    return add( HumongousInt.of( Integer.toString( i ) ) );
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder( digits.length );
    for( byte b : digits ) {
        builder.append( b );
    }
    return ( digits[ 0 ] == ( byte ) 0 ) ? builder.substring( 1 ) : builder.toString();
}
}