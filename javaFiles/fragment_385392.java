<int:header-enricher>
        <int:header name="expectedResponseType">
            <int-groovy:script>
                <![CDATA[
                    new org.springframework.core.ParameterizedTypeReference<List<com.that.service.service.test.ApplicationTestDomain>>() {}
                ]]>
            </int-groovy:script>       
        </int:header>
</int:header-enricher>

<int-http:outbound-gateway request-channel="applicationConfigurationRequest" 
                       reply-channel="testJsonToObjectChannel"
                       url="http://localhost:8080/testapplication/services/application/testService"
                       http-method="GET"
                       expected-response-type-expression="headers.expectedResponseType"/>