Widget testWidget = mock(Widget.class);
when(em.find(Widget.class, "foo")).thenReturn(testWidget);

classUnderTest.discontinueWidget("en");

//something needed here to check whether testWidget was set to discontinued
verify(testWidget).setDiscontinued(true);  

//this checks the merge method was called but not whether the
//discontinued value has been set to true
verify(em).merge(testWidget );