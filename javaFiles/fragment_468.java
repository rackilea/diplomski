method processWSDL(Document wsdl) {
    for each ("/wsdl:definitions/wsdl:types/xsd:schema" in wsdl) {
        call processXSD("inline_[i].xsd",".")
    }
    for each ("/wsdl:definitions/wsdl:import" in wsdl) {
        Document x = read and parse ("@location")
        if (x is WSDL) call processWSDL(x)
        else if (x is XSD) call processXSD("@location", x)
    }
}

method processXSD(String filename, Document xsd) {
    write "xsd" to a new file "filename"   // if 'filename' is a URL, take only the part after the last '/'
    for each ("/xsd:schema/xsd:import" or "/xsd:schema/xsd:include" in xsd) {
        if ("@schemaLocation" is local reference) {     // no 'http://' prefix
            Document x = read and parse ("@schemaLocation")
            call processXSD("@schemaLocation", x)
        }
    }
}