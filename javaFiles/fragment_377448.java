@Test
public void yourTestMethod(){
    YourClass yourClass = new YourClass();
    ThreadMXBean mock = Mockito.mock(ThreadMXBean.class)
    Mockito.when(mxbean.getThreadCpuTime(1L)).thenReturn(1);
    Mockito.when(mxbean.getThreadCpuTime(2L)).thenReturn(2);
    yourClass.mxbean = mock;
    assertThat(yourClass.compare(1L, 2L), is(-1));
}