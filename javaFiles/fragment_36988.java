import path.to.package.containg.test.for.project1.testAll.*;
import path.to.package.containg.test.for.project2.testAll.*;
import path.to.package.containg.test.for.projectX.testAll.*;


@RunWith(Suite.class)
@Suite.SuiteClasses( {
    TestAllProject1.class, //Refrence to a TestAll class
    TestAllProject2.class, //Refrence to a TestAll class
    TestAllProjectX.class  //Refrence to a TestAll class

} )

public class TestAllProjects {}