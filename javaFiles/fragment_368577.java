@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest
{
    @Mock
    private GenericDao<Absence>  absenceDao;
    @Mock
    private GenericDao<Credit>   creditDao;
    @Mock
    private GenericDao<Employee> employeeDao;
    @InjectMocks
    private EmployeeService      employeeService;

    @Test
    public void testGetObject()
    {
        Mockito.when(absenceDao.getObject()).thenReturn(new Absence());
        Mockito.when(creditDao.getObject()).thenReturn(new Credit());
        Mockito.when(employeeDao.getObject()).thenReturn(new Employee());

        Assert.assertNotNull(employeeService.getEmployeeObject());

        Mockito.verify(absenceDao, Mockito.never()).getObject();
        Mockito.verify(creditDao, Mockito.never()).getObject();
        Mockito.verify(employeeDao, Mockito.times(1)).getObject();
    }
}