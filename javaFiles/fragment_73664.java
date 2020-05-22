<http-conf:conduit name="{http://schemas.foobar.com/websvc/WebServiceClass/}WebServiceClassSoap.http-conduit">
        <http-conf:authorization>
                <!-- 
                <sec:UserName>${webservices.username}@${webservices.domain}</sec:UserName>
                <sec:Password>${webservices.password}</sec:Password>
                -->
                <sec:AuthorizationType>Basic</sec:AuthorizationType>
        </http-conf:authorization>
        <http-conf:client AllowChunking="false" ConnectionTimeout="30000" />            
</http-conf:conduit>