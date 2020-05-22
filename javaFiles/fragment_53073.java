@RunWith(MockitoRunner.class)
public class SomeFunTest {
    @Mock Service mockedService;
    @Captor ArgumentCaptor<Runnable /* or whatever type of function you expect there*/> functionCaptor;

    @Test
    public void serviceShouldInvokeFunction() {
        // given
        ObjectUnderTest out = new ObjectUnderTest(mockedService);

        // when
        out.SomeFun();

        // then
        verify(mockedService).execute(captor.capture());

        /* Do your assertions after you captured the value */
        assertThat(captor.getValue()).isInstanceOf(Runnable.class); 
    }
}