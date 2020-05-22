@RunWith(PowerMockRunner.class)
@PrepareForTest(DatagramPacket.class)
public class UDPPacket_TEST {

    DatagramPacket mDatagramPacket;
    UDPPacket mPacket;
    InetAddress addRet;

    @Before
    public void setup() {
        mDatagramPacket = PowerMockito.mock(DatagramPacket.class);
        addRet = mock(InetAddress.class);
        when(addRet.getHostAddress()).thenReturn("90.35.52.52");
        PowerMockito.when(mDatagramPacket.getPort()).thenReturn(25200);
    }

    @Test
    public void test() {
        byte[] packetData = "heartbeat^0a552".getBytes();
        Whitebox.setInternalState(mDatagramPacket, "buf", packetData);
        Whitebox.setInternalState(mDatagramPacket, "address", addRet);
        Whitebox.setInternalState(mDatagramPacket, "port", 25200);
        PowerMockito.when(mDatagramPacket.getData()).thenReturn(packetData);

        mPacket = new UDPPacket(mDatagramPacket);

        System.out.println(String.format("IP: %s, Port: %d, Data: %s", mPacket.getIP(), mPacket.getPort(), mPacket.getData()));
    }

}