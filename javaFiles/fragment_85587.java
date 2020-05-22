Your jars & xml is in
C:\JARs> yoursource.jar, testng.jsr, testng.xml

Your testsuite must contain proper path to testng.xml
List<String> files=new ArrayList<String>();
files.add("C:\\JARs\\testng.xml");

Now try to execute testsuite 
c:\JARs> java -cp "yoursource.jar":"testng.jar" test.TestngTestSuiteUsingXML