try {
            SOAPMessage saajMessage = saajSoapMessage.getSaajMessage();

            saajMessage.getSOAPPart().getEnvelope().removeNamespaceDeclaration("SOAP-ENV");
            saajMessage.getSOAPPart().getEnvelope().addNamespaceDeclaration("ims", "http://www.imsglobal.org/services/lis/cmsv1p0/wsdl11/sync/imscms_v1p");
            saajMessage.getSOAPPart().getEnvelope().setPrefix("soapenv");
            saajMessage.getSOAPHeader().setPrefix("soapenv");
            saajMessage.getSOAPBody().setPrefix("soapenv");
            saajMessage.saveChanges();
        } catch (SOAPException e) {
            e.printStackTrace();
        }