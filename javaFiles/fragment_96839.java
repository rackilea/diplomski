public class MyRuleTest
{
  private MyRule myRule;
  private ScheduleList scheduleListMock;
  private OrderList orderListMock;

  @Before
  public void setUp() throws Exception
  {
    scheduleListMock = mock(ScheduleList.class);
    orderListMock = mock(OrderList.class);

    myRule = new MyRule(orderListMock, scheduleListMock);
  }

  @Test
  public void testExecute()
  {
    myRule.execute();
    verify(scheduleListMock).foo();
    verify(orderListMock).bar();
  }

...