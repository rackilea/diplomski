//AbstractDummyApc7DAOFactory.java
public class AbstractDummyApc7DAOFactory {
    /** @param real true, for real DAOFactory, false for Junit testing*/
    public static DummyApc7DAOFactory create(boolean real) {
        if (real) {
            //create and return the real DAOFactory object
        }
        else {
            //return dummy implementation for Junit testing, better define in separate class
            return new DummyApc7DAOFactory() {
                public DummyApc7DAO getDAO() {
                    return new DummyApc7DAO() {
                        public List getDummyApc7() {
                            List dummyList = new ArrayList();
                            testApc7 = new DummyApc7();
                            testApc7.setVersion("1.Unit.Test");
                            //....
                            dummyList.add(testApc7);
                            return dummyList;
                        }
                    };
                }
            };
        }
    }
}

//test code in junit test class
@Test
public void testRetrievePlannings() {
    DummyApc7DAOFactory fac = AbstractDummyApc7DAOFactory.create(false);
    testObj.setDummyApc7DAOFactory(fac);
    testObj.retrievePlannings();
    PlanningObject testPO = test.getListPlanningObject().get(0);
    assertEquals(testApc7.getVersion(), testPO.getVersion()); 
    //...
}