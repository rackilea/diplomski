public class  RetrievePlanningsTest {       
        private DummyApc7 testApc7;
        private Apc7Engine testObj = new Apc7Engine();

        @Before
        public void setUp() {
            DummyApc7DAOFactory mockedObj = mock(DummyApc7DAOFactory.class);
            List dummyList = new ArrayList();
            testApc7 = new DummyApc7();
            testApc7.setVersion("1.Unit.Test");
            //....
            dummyList.add(testApc7);
            when(DummyApc7DAOFactory.getDAO().getDummyApc7()).thenReturn(dummyList);
        }

        @Test
        public void testRetrievePlannings() {
            testObj.retrievePlannings();
            PlanningObject testPO = testObj.getListPlanningObject().get(0);
            assertEquals(testApc7.getVersion(), testPO.getVersion()); 
            //...
        }
}