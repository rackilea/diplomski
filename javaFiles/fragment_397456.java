public static void generateOutputWithButton(final ContentHandler contentHandler,  final String msg)  throws SAXException{

        contentHandler.startElement(REPORT_NS, "rmessagewithbutton", "report:rmessagewithbutton",  SAXHelper.NO_ATTR);
         for (String l : StringUtils.split(msg, "\n")) {
                contentHandler.startElement(REPORT_NS, "subelement", "report:subelement",  SAXHelper.NO_ATTR);
                generateIWithButton(contentHandler, l);
                contentHandler.endElement(REPORT_NS, "subelement", "report:subelement");        
         }
        contentHandler.endElement(REPORT_NS, "rmessagewithbutton", "report:rmessagewithbutton");        
    }



<xsl:template match="report:rmessagewithbutton">
    <h2>Running and terminated requests</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Button</th>
        </tr>
        <xsl:apply-templates select="report:subelement"/>
    </table>