package test.java.so;

import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import org.apache.commons.codec.binary.Hex;

@SuppressWarnings("restriction")
public class So39543402 {

    public static void main(String[] args) throws Exception {
                TerminalFactory factory = TerminalFactory.getDefault();
                List<CardTerminal> terminals = factory.terminals().list();
                CardTerminal terminal = terminals.get(0);

                Card card = terminal.connect("*");
                CardChannel channel = card.getBasicChannel();

                String pse = "00A404000E325041592E5359532E444446303100";
                CommandAPDU apdu = new CommandAPDU(Hex.decodeHex(pse.toCharArray()));
                exchangeApdu(channel, apdu);

                apdu = new CommandAPDU(0x00, 0xB2, 0x01, 0x0C, 256);
                exchangeApdu(channel, apdu);
    }

    private static ResponseAPDU exchangeApdu(CardChannel channel, CommandAPDU apdu) throws javax.smartcardio.CardException {
        System.out.println("APDU: " + Hex.encodeHexString(apdu.getBytes()));
        ResponseAPDU r = channel.transmit(apdu);
        System.out.println("Response: " + Hex.encodeHexString(r.getBytes()));
        return r;
    }

}