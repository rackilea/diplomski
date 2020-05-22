@RunWith(SpringJUnit4ClassRunner.class)
Class TestClass{
@MockBean
A mockA
@MockBean
B mockB
@MockBean
C mockC
@Autowired
D mockD

@Before
public void setUp() {
mockD = new D(mockA,mockB);
MockitoAnnotations.initMocks(this);
when(mockA.getValue()).then("StringValA");
when(mockB.getValue()).then("StringValB");
when(mockC.getValue()).then("StringValC");

}
@Test
public void testMethod(){
mock.getAllValues();// It will call all injested bean method we are mocked in @before 
}
}