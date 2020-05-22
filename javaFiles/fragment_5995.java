@Test
public void validDatesInRange() {
    ServiceContext context = Mockito.mock(ServiceContext.class);
    Calendar calenderstart = Mockito.mock(Calendar.class);
    Mockito.when(calendarstart.getTimeInMillis()).thenReturn(1L);

    Calendar calendertarget = Mockito.mock(Calendar.class);
    Mockito.when(calendartarget.getTimeInMillis()).thenReturn(2L);

    Calendar calenderend = Mockito.mock(Calendar.class);
    Mockito.when(calendarend.getTimeInMillis()).thenReturn(3L);

    Mockito.when(context.getParameter(ServiceConstants.TIMELINE_END)).thenReturn(calenderend);
    Mockito.when(context.getParameter(ServiceConstants.TIMELINE_BEGIN)).thenReturn(calenderstart);

    TestBaseTimelineProvider provider = new TestBaseTimelineProvider();
    boolean answer = provider.isDateWithinTimelineRange(calendertarget, context);

    assertNotNull(answer);
    assertTrue(provider.isDateWithinTimelineRange(calendartarget, context));
}