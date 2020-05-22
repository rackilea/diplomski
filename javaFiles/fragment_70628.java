[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.jvnet.hyperjaxb3:hyperjaxb3-ejb-template-basic-maven:jar:0.6.0
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 75, column 12
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] Using the builder org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder with a thread count of 1
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Hyperjaxb3 Samples [po-initial:maven] 0.6.0
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ hyperjaxb3-ejb-template-basic-maven ---
[INFO] Deleting C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target
[INFO] 
[INFO] --- maven-hyperjaxb3-plugin:0.6.0:generate (default) @ hyperjaxb3-ejb-template-basic-maven ---
[INFO] Sources are not up-to-date; XJC execution will be executed.
[WARNING] According to the Java Persistence API specification, section 2.1, entities must be top-level classes:
"The entity class must be a top-level class."
Your JAXB model is not customized as with top-level local scoping, please use the <jaxb:globalBinding localScoping="toplevel"/> global bindings customization.
        org.jvnet.hyperjaxb3.ejb.plugin.EjbPlugin

[WARNING] According to the Java Persistence API specification, section 2.1, entities must implement the serializable interface:
"If an entity instance is to be passed by value as a detached object
(e.g., through a remote interface), the entity class must implement
 the Serializable interface."
Your JAXB model is not customized as serializable, please use the <jaxb:serializable/> global bindings customization element to make your model serializable.
        org.jvnet.hyperjaxb3.ejb.plugin.EjbPlugin

[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hyperjaxb3-ejb-template-basic-maven ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] Copying 0 resource
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:2.5.1:compile (default-compile) @ hyperjaxb3-ejb-template-basic-maven ---
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 5 source files to C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ hyperjaxb3-ejb-template-basic-maven ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:2.5.1:testCompile (default-testCompile) @ hyperjaxb3-ejb-template-basic-maven ---
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 5 source files to C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ hyperjaxb3-ejb-template-basic-maven ---
[INFO] Surefire report directory: C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running RoundtripTest
Detected [file:/C:/Projects/workspaces/hj3/dist/hyperjaxb3-ejb-template-basic-0.6.0/target/classes/META-INF/persistence.xml].
    RoundtripTest

Loading entity manager factory properties.
    RoundtripTest

Loading entity manager factory properties from [file:/C:/Projects/workspaces/hj3/dist/hyperjaxb3-ejb-template-basic-0.6.0/target/test-classes/persistence.properties].
    RoundtripTest

Testing samples.
    RoundtripTest

Sample directory [C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\src\test\samples].
    RoundtripTest

Testing sample [po.xml].
    RoundtripTest

Unmarshalling.
    RoundtripTest

Opening session.
    RoundtripTest

Saving the object.
    RoundtripTest

Opening session.
    RoundtripTest

Loading the object.
    RoundtripTest

Closing the session.
    RoundtripTest

Initial object:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<purchaseOrder orderDate="1999-10-20">
    <shipTo country="US">
        <name>Alice Smith</name>
        <street>123 Maple Street</street>
        <city>Mill Valley</city>
        <state>CA</state>
        <zip>90952</zip>
    </shipTo>
    <billTo country="US">
        <name>Robert Smith</name>
        <street>8 Oak Avenue</street>
        <city>Old Town</city>
        <state>PA</state>
        <zip>95819</zip>
    </billTo>
    <comment>Hurry, my lawn is going wild!</comment>
    <items>
        <item partNum="872-AA">
            <productName>Lawnmower</productName>
            <quantity>1</quantity>
            <USPrice>148.95</USPrice>
            <comment>Confirm this is electric</comment>
        </item>
        <item partNum="926-AA">
            <productName>Baby Monitor</productName>
            <quantity>1</quantity>
            <USPrice>39.98</USPrice>
            <shipDate>1999-05-21</shipDate>
        </item>
    </items>
</purchaseOrder>

    RoundtripTest

Source object:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<purchaseOrder orderDate="1999-10-20" Hjid="1">
    <shipTo country="US" Hjid="2">
        <name>Alice Smith</name>
        <street>123 Maple Street</street>
        <city>Mill Valley</city>
        <state>CA</state>
        <zip>90952</zip>
    </shipTo>
    <billTo country="US" Hjid="1">
        <name>Robert Smith</name>
        <street>8 Oak Avenue</street>
        <city>Old Town</city>
        <state>PA</state>
        <zip>95819</zip>
    </billTo>
    <comment>Hurry, my lawn is going wild!</comment>
    <items Hjid="1">
        <item partNum="872-AA" Hjid="1">
            <productName>Lawnmower</productName>
            <quantity>1</quantity>
            <USPrice>148.95</USPrice>
            <comment>Confirm this is electric</comment>
        </item>
        <item partNum="926-AA" Hjid="2">
            <productName>Baby Monitor</productName>
            <quantity>1</quantity>
            <USPrice>39.98</USPrice>
            <shipDate>1999-05-21</shipDate>
        </item>
    </items>
</purchaseOrder>

    RoundtripTest

Result object:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<purchaseOrder orderDate="1999-10-20" Hjid="1">
    <shipTo country="US" Hjid="2">
        <name>Alice Smith</name>
        <street>123 Maple Street</street>
        <city>Mill Valley</city>
        <state>CA</state>
        <zip>90952</zip>
    </shipTo>
    <billTo country="US" Hjid="1">
        <name>Robert Smith</name>
        <street>8 Oak Avenue</street>
        <city>Old Town</city>
        <state>PA</state>
        <zip>95819</zip>
    </billTo>
    <comment>Hurry, my lawn is going wild!</comment>
    <items Hjid="1">
        <item partNum="872-AA" Hjid="1">
            <productName>Lawnmower</productName>
            <quantity>1</quantity>
            <USPrice>148.95</USPrice>
            <comment>Confirm this is electric</comment>
        </item>
        <item partNum="926-AA" Hjid="2">
            <productName>Baby Monitor</productName>
            <quantity>1</quantity>
            <USPrice>39.98</USPrice>
            <shipDate>1999-05-21</shipDate>
        </item>
    </items>
</purchaseOrder>

    RoundtripTest

Checking the document identity.
    RoundtripTest

Finished testing sample [po.xml].
    RoundtripTest

Finished testing samples.
    RoundtripTest

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.456 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ hyperjaxb3-ejb-template-basic-maven ---
[INFO] Building jar: C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target\hyperjaxb3-ejb-template-basic-maven-0.6.0.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ hyperjaxb3-ejb-template-basic-maven ---
[INFO] Installing C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\target\hyperjaxb3-ejb-template-basic-maven-0.6.0.jar to C:\Repository\org\jvnet\hyperjaxb3\hyperjaxb3-ejb-template-basic-maven\0.6.0\hyperjaxb3-ejb-template-basic-maven-0.6.0.jar
[INFO] Installing C:\Projects\workspaces\hj3\dist\hyperjaxb3-ejb-template-basic-0.6.0\pom.xml to C:\Repository\org\jvnet\hyperjaxb3\hyperjaxb3-ejb-template-basic-maven\0.6.0\hyperjaxb3-ejb-template-basic-maven-0.6.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 11.185 s
[INFO] Finished at: 2014-10-09T00:56:18+01:00
[INFO] Final Memory: 22M/101M
[INFO] ------------------------------------------------------------------------