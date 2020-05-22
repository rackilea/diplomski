/* in your system under test */
someSystem.interact(new Widget(4));

/* in your test */
verify(mockSystem).interact(widgetCaptor.capture());
Widget widgetInteractedWith = widgetCaptor.getValue();
assertEquals(4, widgetInteractedWith.getParameter());
doOtherAssertionsOn(widgetInteractedWith);