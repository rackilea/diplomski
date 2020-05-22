<Test version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:date="xalan://java.text.SimpleDateFormat"
        xmlns:java="http://xml.apache.org/xslt/java">
               <xsl:variable name="iso-date"
                select='date:new("yyyy-MM-dd&apos;T&apos;hh:mm:ssXXX")' />
    <xsl:value-of select="java:format($iso-date, java:java.util.Date.new())"/>
</Test>