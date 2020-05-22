@Test
public void testDeleteEnrollExpectSuccess() {
    Enroll enroll = prepareEnrollWithBedAllocation();
    enrollService.delete(enroll.getId());
    verify(enrollRepository, times(1)).deleteById(enroll.getId());
}