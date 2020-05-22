@Spy
private Recruiter recR;

public void testGrowTeam(  ) { 

     // Setup canned data return
     doReturn(generateTestEmployee()).when(recR).srcEmployee(any(Object.class));

    expect( recR.srcEmployee( blah) ).andReturn( blah )...
    // exercising/assertions/validations as usual...
}