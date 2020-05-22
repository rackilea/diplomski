@RunWith(MockitoJUnitRunner.class)
public class PersonalDataDaoTest {

    @Mock
    private PreparedStatement psmt;
    @Mock
    private StatmentProvider statementProvider; 

    @InjectMocks
    private PersonalDataDao newDAO; // This is the class under test
    @Test
    public void HappyTestForInsert() throws SQLException, DAOException, ClassNotFoundException {
        when(statementProvider.createInsertStatementForPersonalData()).thenReturn(psmt);
        //ArgumentCaptor<Integer> intcaptor = ArgumentCaptor.forClass(int.class);
        ArgumentCaptor<String> stringcaptor = ArgumentCaptor.forClass(String.class);
        String id = "11";
        String patientName = "yara";
        String birthDate = "2001-12-5";
        String placeOfBirth = "cairo";
        String gender = "female";
        String nationality = "egyptian";
        String currentAddress = "cairo";
        String cityAddress = "cairo";
        String maritalStatus = "married";
        String offspring = "1";
        String ageOfYoungestOffspring = "2";
        String workNature = "teacher";
        String phoneNumber = "0324324234";
        String eMail = "yara@hotmail.com";

        PersonalData p = new PersonalData(id, patientName, birthDate, placeOfBirth, gender, nationality, currentAddress, cityAddress, maritalStatus, offspring, ageOfYoungestOffspring, workNature, phoneNumber, eMail);
        newDAO.InsertPersonalData(p);
        //verify(psmt, times(1)).setInt(anyInt(), intcaptor.capture());
        verify(psmt, times(14)).setString(anyInt(), stringcaptor.capture());
        Assert.assertTrue(stringcaptor.getAllValues().get(0).equals(id));
        Assert.assertTrue(stringcaptor.getAllValues().get(1).equals(patientName));
        Assert.assertTrue(stringcaptor.getAllValues().get(2).equals(birthDate));
        Assert.assertTrue(stringcaptor.getAllValues().get(3).equals(placeOfBirth));
        Assert.assertTrue(stringcaptor.getAllValues().get(4).equals(gender));
        Assert.assertTrue(stringcaptor.getAllValues().get(5).equals(nationality));
        Assert.assertTrue(stringcaptor.getAllValues().get(6).equals(currentAddress));
        Assert.assertTrue(stringcaptor.getAllValues().get(7).equals(cityAddress));
        Assert.assertTrue(stringcaptor.getAllValues().get(8).equals(maritalStatus));
        Assert.assertTrue(stringcaptor.getAllValues().get(9).equals(offspring));
        Assert.assertTrue(stringcaptor.getAllValues().get(10).equals(ageOfYoungestOffspring));
        Assert.assertTrue(stringcaptor.getAllValues().get(11).equals(workNature));
        Assert.assertTrue(stringcaptor.getAllValues().get(12).equals(phoneNumber));
        Assert.assertTrue(stringcaptor.getAllValues().get(13).equals(eMail));

    }
}