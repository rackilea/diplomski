InOrder inOrder = inOrder(o, myObjectDAOMock);

inOrder.verify(o).setComment("...");
// 1.) inOrder.verify(o, times(0)).setComment(anyString());
inOrder.verify(myObjectDAOMock).updateMyObject(o);

// 2.) assertEquals(o.getComment(), "comment");

// 3.) verifyNoMoreInteractions(o);