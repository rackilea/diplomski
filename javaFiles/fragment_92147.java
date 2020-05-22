import sim.toolkit.ToolkitInterface;
import sim.toolkit.ToolkitRegistry;
...
import javacard.framework.ISOException;

public class STKTest extends Applet implements ToolkitInterface {

public static void install(byte[] bArray, short bOffset, byte bLength) {
    // GP-compliant JavaCard applet registration
    new STKTest().register(bArray, (short) (bOffset + 1), bArray[bOffset]);
}
//this method handles standard APDU commands
public void process(APDU apdu) {
    // Good practice: Return 9000 on SELECT
    if (selectingApplet()) {
        return;
    }

    apdu.setIncomingAndReceive();
    final byte[] buf = apdu.getBuffer();
    switch (buf[ISO7816.OFFSET_INS]) {
    case (byte) 0x00:
        //do something
        break;
    }
}
//this method handles the SIM Toolkit commands
public void processToolkit(byte event) throws ToolkitException {
    switch (event) {

    case ToolkitConstants.EVENT_TIMER_EXPIRATION:
        //do something
        break;
    }
}

}