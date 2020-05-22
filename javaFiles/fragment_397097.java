private DescribeHiveTable mockObj; // must be accessible to Test methods

@Before
public void initialize(){
    this.mockObj = Mockito.mock(DescribeHiveTable.class);
    <etc>
}

@Test
public void testComplexFeaturesExistingRun() {
    /* test the objects that are set up to use this.mockObj,
       and not the usual type of DescribeHiveTable */
}