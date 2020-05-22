//Get soapElement from your soap request.
if (soapElement.getTagName().equalsIgnoreCase("calculate_response")) {
       soapElement.setElementQName(
         new QName("http://com.sample.xyz/Messages",
                  "calculate_response",
                  "def"));