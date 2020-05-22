public class MicrophoneTest {

    private Microphone microphone;

    @Test
    public void testGetData(){
        microphone = new Microphone("test");
        ArrayList data = microphone.getData();
        assertNotNull(data);
        assertEquals(data.size(), 2); // 2 is the expected size    

    }

}