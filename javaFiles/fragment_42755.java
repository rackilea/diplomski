open module myapp.merged.module {
    requires java.xml;

    exports com.fasterxml.jackson.annotation;
    exports com.fasterxml.jackson.core;
    exports com.fasterxml.jackson.core.async;
    ...
    exports schemaorg_apache_xmlbeans.system.sXMLTOOLS;
}