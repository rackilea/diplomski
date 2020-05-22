@Test(expected = RuntimeException.class)
public void testSaveUserFailsOnAddDueToTimeout() {
    when(couchbase.incr(anyString(), anyInt())).thenReturn(0L);
    when(couchbase.add(anyString(), anyObject())).thenThrow(InterruptedException.class);
    this.userDao.saveUser(SOURCE);
}