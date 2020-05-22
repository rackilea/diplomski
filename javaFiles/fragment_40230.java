// Verify that the three invocations arrived in the desired order.
InOrder inOrder = inOrder(tool);
inOrder.verify(tool).begin();
inOrder.verify(tool).end();
inOrder.verify(tool).flush();

// Verify that the three invocations are all we received.
Mockito.verify(tool).begin();
Mockito.verify(tool).end();
Mockito.verify(tool).flush();
Mockito.verifyNoMoreInteractions();