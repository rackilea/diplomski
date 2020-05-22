open module myapp.merged.module {
    exports com.fasterxml.jackson.annotation;
    exports com.fasterxml.jackson.core;
    exports com.fasterxml.jackson.core.async;
    ...
    exports schemaorg_apache_xmlbeans.system.sXMLTOOLS;
    requires java.xml.crypto;
    requires java.logging;
    requires java.sql;
    requires java.xml;
    requires java.desktop;
    requires java.security.jgss;
    requires jdk.javadoc;
    uses java.nio.file.spi.FileSystemProvider;
    provides com.fasterxml.jackson.core.JsonFactory with com.fasterxml.jackson.core.JsonFactory;
    provides com.fasterxml.jackson.core.ObjectCodec with com.fasterxml.jackson.databind.ObjectMapper;
    provides org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface with org.apache.xmlbeans.impl.xquery.saxon.XBeansXQuery;
    provides org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface with org.apache.xmlbeans.impl.xpath.saxon.XBeansXPath;
}