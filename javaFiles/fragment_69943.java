Exception in thread "main" javax.ws.rs.WebApplicationException: javax.xml.bind.UnmarshalException
 - with linked exception:
[com.sun.istack.internal.SAXParseException2; lineNumber: 0; columnNumber: 0; unexpected element (uri:"", local:"id"). Expected elements are <{}person>]
    at com.sun.jersey.core.provider.jaxb.AbstractListElementProvider.readFrom(AbstractListElementProvider.java:251)
    at com.sun.jersey.api.client.ClientResponse.getEntity(ClientResponse.java:553)
    at com.sun.jersey.api.client.ClientResponse.getEntity(ClientResponse.java:523)
    at soatestclient.SOATestClient.main(SOATestClient.java:33)
Caused by: javax.xml.bind.UnmarshalException