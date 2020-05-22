<xsd:attribute name="reply-timeout" type="xsd:string">
        <xsd:annotation>
            <xsd:documentation>
                <![CDATA[
                Specifies how long this gateway will wait for the reply message
                before returning. By default it will wait indefinitely. 'null' is returned
                if the gateway times out.
                Value is specified in milliseconds; it can be a simple long value or a SpEL
                expression; array variable '#args' is available.
                Also used for receive-only operations as the receive timeout.
                ]]>
            </xsd:documentation>
        </xsd:annotation>
    </xsd:attribute>