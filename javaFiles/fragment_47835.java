/* in your system under test */
someSystem.setPowerLevel(9001);
someSystem.interact(new Widget(4));

/* in your test */
verify(mockSystem).setPowerLevel(gt(9000));  // greater than 9000
verify(mockSystem).interact(argThat(isAWidgetWithParameter(4)));