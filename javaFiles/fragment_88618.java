import org.codehaus.jackson.annotate.JsonProperty;         

public class OverallWrapper {                              

    private TestSuite testSuite;                           

    @JsonProperty("TestSuite")                             
    public TestSuite getTestSuite() {                      
        return this.testSuite;                             
    }                                                      

    public void setTestSuite(final TestSuite testSuite) {  
        this.testSuite = testSuite;                        
    }                                                      
}



import java.util.List;                                                                                                                                  
import org.codehaus.jackson.annotate.JsonProperty;                              

public class TestSuite {                                                        

    private TestSuiteInfo testSuiteInfo;                                        

    private List<TestCaseDataWrapper> testCaseData;                             

    @JsonProperty("TestCase")                                                   
    public List<TestCaseDataWrapper> getTestCaseData() {                        
        return this.testCaseData;                                               
    }                                                                           

    public void setTestCaseData(final List<TestCaseDataWrapper> testCaseData) { 
        this.testCaseData = testCaseData;                                       
    }                                                                           

    @JsonProperty("TestSuiteInfo")                                              
    public TestSuiteInfo getTestSuiteInfo() {                                   
        return this.testSuiteInfo;                                              
    }                                                                           

    public void setTestSuiteInfo(final TestSuiteInfo testSuiteInfo) {           
        this.testSuiteInfo = testSuiteInfo;                                     
    }                                                                                                                                                   
}          



import org.codehaus.jackson.annotate.JsonProperty;          

public class TestSuiteInfo {                                

    private String description;                             

    @JsonProperty("-description")                           
    public String getDescription() {                        
        return this.description;                            
    }                                                       
    public void setDescription(final String description) {  
        this.description = description;                     
    }                                                       
}                                                                                                                                



import org.codehaus.jackson.annotate.JsonProperty;                  

public class TestCaseDataWrapper {                                  

    @JsonProperty("TestCaseData")                                   
    private TestCaseData testcaseData;                              

    public TestCaseData getTestcaseData() {                         
        return this.testcaseData;                                   
    }                                                               

    public void setTestcaseData(final TestCaseData testcaseData) {  
        this.testcaseData = testcaseData;                           
    }                                                               
}       



import org.codehaus.jackson.annotate.JsonProperty;             

public class TestCaseData {                                    

    private String sequence;                                   
    private int testNumber;                                    
    private String testCaseFile;                               

    @JsonProperty("-sequence")                                 
    public String getSequence() {                              
        return this.sequence;                                  
    }                                                          

    public void setSequence(final String sequence) {           
        this.sequence = sequence;                              
    }                                                          

    @JsonProperty("-testNumber")                               
    public int getTestNumber() {                               
        return this.testNumber;                                
    }                                                          

    public void setTestNumber(final int testNumber) {          
        this.testNumber = testNumber;                          
    }                                                          

    @JsonProperty("-testCaseFile")                             
    public String getTestCaseFile() {                          
        return this.testCaseFile;                              
    }                                                          

    public void setTestCaseFile(final String testCaseFile) {   
        this.testCaseFile = testCaseFile;                      
    }                                                          
}                                                              



public static void main(final String[] args) {

    final String json = "{\"TestSuite\":{\"TestSuiteInfo\":{\"-description\":\"parse\"},\"TestCase\":[" +
            "{\"TestCaseData\":{\"-sequence\":\"sequential\",\"-testNumber\":\"2\",\"-testCaseFile\":\"testcase\\\\Web\\\\Ab.xml\"}}," +
            "{\"TestCaseData\":{\"-sequence\":\"sequential\",\"-testNumber\":\"3\",\"-testCaseFile\":\"testcase\\\\Web\\\\BC.xml\"}}" +
            "]}}";

    final ObjectMapper mapper = new ObjectMapper();

    try {
        final OverallWrapper readValue = mapper.readValue(json, OverallWrapper.class);

        System.out.println(readValue.getTestSuite());
    }
    catch (final Exception e) {
        e.printStackTrace();
    }
}