<xsd:complexType name="FooType">
    <xsd:annotation>
        <xsd:appinfo>
            <annox:annotate>@java.lang.SuppressWarnings({"unchecked","rawtypes"})</annox:annotate>
            <annox:annotate target="package">@javax.annotation.Generated({"XJC","JAXB2 Annotate Plugin"})</annox:annotate>
        </xsd:appinfo>
    </xsd:annotation>
    <xsd:sequence>
        <xsd:element name="bar" type="xsd:string"/>
        <xsd:element name="foobar" type="xsd:string">
            <xsd:annotation>
                <xsd:appinfo>
                    <annox:annotate>@java.lang.SuppressWarnings({"unchecked","rawtypes"})</annox:annotate>
                    <annox:annotate target="setter">@java.lang.Deprecated</annox:annotate>
                    <annox:annotate target="setter-parameter">@java.lang.Deprecated</annox:annotate>
                    <annox:annotate target="getter">@java.lang.Deprecated</annox:annotate>
                    <annox:annotate target="field">@java.lang.Deprecated</annox:annotate>
                    <annox:annotate target="class">@java.lang.Deprecated</annox:annotate>
                </xsd:appinfo>
            </xsd:annotation>
        </xsd:element>
    </xsd:sequence>
</xsd:complexType>