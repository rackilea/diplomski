import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

public class TestPcsc {

    public static void main( String[] args ) throws CardException {

        TerminalFactory tf = TerminalFactory.getDefault();
        List< CardTerminal > terminals = tf.terminals().list();
        CardTerminal cardTerminal = (CardTerminal) terminals.get( 0 );

        byte[] command = { (byte) 0xE0, (byte) 0x00, (byte) 0x00, (byte) 0x29, (byte) 0x01, (byte) 0x00 };
        cardTerminal.connect( "DIRECT" ).transmitControlCommand( CONTROL_CODE(), command );

    }

    public static int CONTROL_CODE() {

        String osName = System.getProperty( "os.name" ).toLowerCase();
        if ( osName.indexOf( "windows" ) > -1 ) {
            /* Value used by both MS' CCID driver and SpringCard's CCID driver */
            return (0x31 << 16 | 3500 << 2);
        }
        else {
            /* Value used by PCSC-Lite */
            return 0x42000000 + 1;
        }

    }

}