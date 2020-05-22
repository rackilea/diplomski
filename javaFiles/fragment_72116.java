@RunWith(MockitoJunitRunner.class)
class ConfTest {
    @InjectMocks MyConf sut;
    @Mock Resource xyz;

    @Test(expected = InvalidParameterException.class)
    public void testInvalidResourceThrowsException() {
        when(xyz.mappedName()).thenReturn("invalid"); // or something
        OtherBean param = mock(OtherBean.class);

        sut.getMyService(param);
    }
}