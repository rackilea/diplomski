@Test
public void mySampleTest() throws Exception {
    reset(aggregationHelper);
    // Set expectations on the aggregationHelper
    replay(blockToTicketMapHelper);
    aggregationActor.receive(new AggregationVO();
    saveActor.expectMsg(new SaveVO());        
}