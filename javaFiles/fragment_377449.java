@RunWith(MockitoJUnitRunner.class)
public class YourTest{

    @InjectMocks YourClass yourClass = new YourClass();
    @Mock ThreadMXBean mock;

    @Test
    public void yourTestMethodDoesntNeedToCreateMocksAnymore(){
        Mockito.when(mxbean.getThreadCpuTime(1L)).thenReturn(1);
        Mockito.when(mxbean.getThreadCpuTime(2L)).thenReturn(2);
        assertThat(yourClass.compare(1L, 2L), is(-1));
    }


}