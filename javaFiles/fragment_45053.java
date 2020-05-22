import com.eviware.soapui.impl.wsdl.*
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep
import com.eviware.soapui.model.testsuite.TestAssertion
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.SimpleContainsAssertion
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestStep

WsdlProject wadlProject = new WsdlProject();    
WsdlTestSuite ts =  wadlProject.addNewTestSuite("HelloTestSuite");
WsdlTestCase tc = ts.addNewTestCase("HelloTestCase1");
WsdlTestStep testStep = tc.addTestStep("httprequest","HelloTestStep1",ip_addr+":"+port,"POST");
TestAssertion assertion = ((HttpTestRequestStep)testStep).addAssertion("Contains");
((SimpleContainsAssertion)assertion).setToken("success");