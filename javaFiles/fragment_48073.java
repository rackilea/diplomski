<route>
     <from uri="timer://foo?fixedRate=true&amp;period=60000"/>
     <setHeader headerName="CamelHttpMethod">
         <constant>POST</constant>
     </setHeader>
     <setHeader headerName="Content-type">
         <constant>text/xml;charset=UTF-8</constant>
     </setHeader>
     <setHeader headerName="Accept-Encoding">
         <constant>gzip,deflate</constant>
     </setHeader>

     <setBody>
         <constant><![CDATA[<SOAP:Envelope xmlns:SOAP="http://schemas.xmlsoap.org/soap/envelope/"><SOAP:Header></SOAP:Header><SOAP:Body></SOAP:Body></SOAP:Envelope>]]>
      </constant>
      </setBody>
      <to uri="https://localhost:8443/api"/>
      <log message="${out.body}"/>
  </route>