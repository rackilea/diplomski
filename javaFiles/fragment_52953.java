@RunWith(JUnitParamsRunner.class)
public class ServiceTest {

    @Test
    @Parameters({
            "first.xml, first.csv",
            "second.xml, second.csv",
            "third.xml, third.csv"
    })
    public void shouldServe(String xmlFilePath, String csvFilePath) {
        String xmlFileContent = readContent(xmlFilePath);
        String csvFileContent = readContent(csvFilePath);

        // call your business method here passing 
        // dynamic xml, csv and static params
    }
}