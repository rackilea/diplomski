@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
    @Mock
    private BankDao bankDao;

    @InjectMocks
    private Account account;

    @Test
    public void reserveVoid_mockBankDaoAndDontUseRealMethod() {
        doNothing().when(bankDao).createVoid();
        account.reserveVoid();
    }

    @Test
    public void reserveString_mockBankDaoAndDontUseRealMethod() {
        when(bankDao.createString()).thenReturn("nothing");
        account.reserveString();
    }
}