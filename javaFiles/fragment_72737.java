<http:conduit name="*.http-conduit">
    <http:tlsClientParameters>
        <sec:keyManagers keyPassword="${ssl.keystorepassword}">
            <sec:keyStore type="JKS" password="${ssl.keystorepassword}"
                file="${ssl.keystorefile}" />
        </sec:keyManagers>
        <sec:cipherSuitesFilter>
            <sec:include>.*_EXPORT_.*</sec:include>
            <sec:include>.*_EXPORT1024_.*</sec:include>
            <sec:include>.*_WITH_DES_.*</sec:include>
            <sec:include>.*_WITH_AES_.*</sec:include>
            <sec:include>.*_WITH_NULL_.*</sec:include>
            <sec:exclude>.*_DH_anon_.*</sec:exclude>
        </sec:cipherSuitesFilter>
    </http:tlsClientParameters>
    <http:authorization>
    </http:authorization>
    <http:client AutoRedirect="true" Connection="Keep-Alive" />
</http:conduit>