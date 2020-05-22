<suite name="SampleTest_TestSuite1" verbose="1">
<parameter name="component" value="${component.name}"/>
<parameter name="version" value="${component.version}"/>

<test name="SampleTest" preserve-order="true" parallel="false">
    <classes>
        ...
    </classes>
</test>
</suite>