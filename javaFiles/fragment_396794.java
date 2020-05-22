@Test
void exceptionTesting() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
        arrayCircleQueue.enQueue('a') ;
    });
    assertEquals("Queue is full now!", exception.getMessage());
}