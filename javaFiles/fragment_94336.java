<http:conduit name="{http://apache.org/hello_world}HelloWorld.http-conduit">

   <http:tlsClientParameters>
       <sec:keyManagers keyPassword="password">
            <sec:keyStore type="JKS" password="password"
                 file="src/test/java/org/apache/cxf/systest/http/resources/Morpit.jks"/>
       </sec:keyManagers>
       <sec:trustManagers>
           <sec:keyStore type="JKS" password="password"
                file="src/test/java/org/apache/cxf/systest/http/resources/Truststore.jks"/>
       </sec:trustManagers>

       ...

   </http:tlsClientParameters>